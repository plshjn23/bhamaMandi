package com.pernia.ui.activities;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.pernia.R;
import com.pernia.ui.adapters.ViewPagerAdapter;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by Palash on 3/5/2017.
 */
public class ProductListingCelebrityActivity extends BaseActionbarActivity {


    public static String mwhereItComeFrom = "";
    static boolean rotatePager = false;
    static int k;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.search_image_view)
    ImageView mSearchImageView;
    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    ArrayList<Integer> productListModelArrayList = new ArrayList<>();
    PagerAdapter adapter;
    int pos = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        Bundle bundle = getIntent().getExtras();
        mwhereItComeFrom = bundle.getString("where");

        if (mwhereItComeFrom.equalsIgnoreCase("")) {

        } else {

            mToolbarTitle.setText("Celebrity");
        }


        productListModelArrayList.add(0, R.drawable.image_dummy);
        productListModelArrayList.add(1, R.drawable.image_dummy);
        productListModelArrayList.add(2, R.drawable.image_dummy);
        productListModelArrayList.add(3, R.drawable.image_dummy);
        productListModelArrayList.add(4, R.drawable.image_dummy);

        adapter = new ViewPagerAdapter(this, productListModelArrayList);
        viewPager.setAdapter(adapter);
        rotateViewPager();


    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_product_listing_celebrity;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;

    }

    private void rotateViewPager() {
        if (rotatePager = true) {
            CountDownTimer countDownTimer = new CountDownTimer(4000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    int pos = viewPager.getCurrentItem();
                    if (pos == productListModelArrayList.size() - 1) {
                        viewPager.setCurrentItem(0);

                    } else {
                        viewPager.setCurrentItem(++pos);

                    }
                    rotateViewPager();
                }
            }.start();

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        k = 0;
        rotatePager = true;


    }
}
