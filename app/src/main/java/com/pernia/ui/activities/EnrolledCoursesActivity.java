package com.pernia.ui.activities;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.pernia.R;

import butterknife.Bind;

import static android.view.View.GONE;

/**
 * Created by om on 3/20/2017.
 */

public class EnrolledCoursesActivity extends BaseActionbarActivity {


    RecyclerView mOfferTabRecyclerView;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;
    @Bind(R.id.search_image_view)
    TextView mSearchImageView;
    private OfferTabAdapterEnrolled offerTabAdapterEnrolled;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        mSearchImageView.setVisibility(GONE);

        mToolbarTitle.setText("My Enrolled Courses");


        mOfferTabRecyclerView = (RecyclerView) findViewById(R.id.offers_recycler_view);
        RecyclerView.LayoutManager mLayoutManagerTopBrands = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        offerTabAdapterEnrolled = new OfferTabAdapterEnrolled(this);
        mOfferTabRecyclerView.setLayoutManager(mLayoutManagerTopBrands);
        mOfferTabRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mOfferTabRecyclerView.setAdapter(offerTabAdapterEnrolled);
        mOfferTabRecyclerView.setNestedScrollingEnabled(false);

    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_enrolled_courses;
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
