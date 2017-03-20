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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pernia.R;

import butterknife.Bind;
import butterknife.OnClick;

import static android.view.View.GONE;

/**
 * Created by om on 3/10/2017.
 */

public class AllCategoriesActivity extends BaseActionbarActivity {

    @Bind(R.id.categories_recycler_view)
    RecyclerView mCategoriesRecyclerView;

    @Bind(R.id.save_category_button)
    Button mSaveButton;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.search_image_view)
    TextView mSearchImageView;
    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;

    private CategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


        mToolbarTitle.setText("Choose Categories");

        mSearchImageView.setVisibility(GONE);

        RecyclerView.LayoutManager mLayoutManagerTopComplaint = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        categoriesAdapter = new CategoriesAdapter(this);
        mCategoriesRecyclerView.setLayoutManager(mLayoutManagerTopComplaint);
        mCategoriesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mCategoriesRecyclerView.setAdapter(categoriesAdapter);
        mCategoriesRecyclerView.setNestedScrollingEnabled(false);


    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_all_categories;
    }

    @OnClick(R.id.save_category_button)
    void saveCategories() {
        finish();
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
