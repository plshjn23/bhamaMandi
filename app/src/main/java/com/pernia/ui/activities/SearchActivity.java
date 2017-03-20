package com.pernia.ui.activities;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.pernia.R;

import butterknife.Bind;

import static android.view.View.GONE;

/**
 * Created by Palash on 3/4/2017.
 */
public class SearchActivity extends BaseActionbarActivity {


    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.search_image_view)
    TextView mSearchImageView;

    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSearchImageView.setText(R.string.fa_cart);


        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        mToolbarTitle.setText("Search");

    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void onResume() {

        mSearchImageView.setVisibility(GONE);
        super.onResume();
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
}
