package com.pernia.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.pernia.R;
import com.pernia.ui.adapters.ViewPagerAdapter;
import com.tiagosantos.enchantedviewpager.EnchantedViewPager;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by gaurav on 8/3/17.
 */

public class ProductDetailActivity extends BaseActionbarActivity {

    static int k;
    static boolean rotatePager = false;
    @Bind(R.id.check_out)
    Button checkout;
    ArrayList<Integer> productListModelArrayList = new ArrayList<>();
    PagerAdapter adapter;
    Toolbar mToolbar;
    TextView mToolbarTitle;
    @Bind(R.id.add_to_bag_button)
    Button mAddtoBagButton;
    @Bind(R.id.search_image_view)
    TextView mSearchImageView;
    boolean is_filled = false;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        mSearchImageView.setText(R.string.fa_wish);

        mToolbarTitle.setText("MonaLisa");

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        productListModelArrayList.add(0, R.drawable.image_dummy);
        productListModelArrayList.add(1, R.drawable.image_dummy);
        productListModelArrayList.add(2, R.drawable.image_dummy);
        productListModelArrayList.add(3, R.drawable.image_dummy);
        productListModelArrayList.add(4, R.drawable.image_dummy);

        adapter = new ViewPagerAdapter(this, productListModelArrayList);
        viewPager.setAdapter(adapter);

        rotateViewPager();
    }


    @OnClick(R.id.check_out)
    public void checkout() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.search_image_view)
    public void search() {
        if (is_filled) {
            is_filled = false;
            mSearchImageView.setText(R.string.fa_wish);
        } else {
            is_filled = true;
            mSearchImageView.setText(R.string.fa_wish_filled);
        }
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_product_detail;
    }


    @Override
    protected void onResume() {
        super.onResume();
        k = 0;
        rotatePager = true;


    }

    @OnClick(R.id.add_to_bag_button)
    void addtobag() {
        Intent intent = new Intent(this, BagActivity.class);
        startActivity(intent);
    }

    private void rotateViewPager() {
//        commonUtility.callLog("LandingPage", "rotateViewPger fn","running");
        if (rotatePager = true) {
            CountDownTimer countDownTimer = new CountDownTimer(4000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    int pos = viewPager.getCurrentItem();
                    if (pos == 4) {
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;

    }
}
