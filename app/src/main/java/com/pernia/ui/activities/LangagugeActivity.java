package com.pernia.ui.activities;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pernia.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

import static android.view.View.GONE;

/**
 * Created by om on 3/20/2017.
 */

public class LangagugeActivity extends BaseActionbarActivity {


    Toolbar mToolbar;
    TextView mToolbarTitle;
    @Bind(R.id.search_image_view)
    TextView mSearchImageView;

    @Bind(R.id.main_relative)
    RelativeLayout main_relative;


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

        mSearchImageView.setVisibility(GONE);

        mToolbarTitle.setText("Select your Desired Language");


    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_language;
    }


    @OnClick(R.id.main_relative)
    void back() {
        onBackPressed();
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

