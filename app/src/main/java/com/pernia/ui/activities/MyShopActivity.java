package com.pernia.ui.activities;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pernia.R;
import com.pernia.ui.adapters.ProductListAdapter;

import butterknife.Bind;
import butterknife.OnClick;

import static android.view.View.GONE;

/**
 * Created by om on 3/10/2017.
 */

public class MyShopActivity extends BaseActionbarActivity {


    public static RelativeLayout main_relative;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.search_image_view)
    TextView mSearchImageView;
    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;
    @Bind(R.id.product_list_recycler_view)
    RecyclerView mProductListRecyclerView;
    GridLayoutManager gridLayoutManager;
    private ProductListAdapterMyShop productListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        main_relative = (RelativeLayout) findViewById(R.id.main_relative);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


        mToolbarTitle.setText("My Shop(Approved products)");
        mSearchImageView.setText(R.string.fa_cart);


        gridLayoutManager = new GridLayoutManager(this, 2);
        productListAdapter = new ProductListAdapterMyShop(this);
        mProductListRecyclerView.setLayoutManager(gridLayoutManager);
        mProductListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mProductListRecyclerView.setAdapter(productListAdapter);
        mProductListRecyclerView.setNestedScrollingEnabled(false);


    }


    @Override
    protected int getActivityLayout() {
        return R.layout.activity_your_shop;
    }

    @OnClick(R.id.search_image_view)
    public void jumpToSearch() {
        Intent intent = new Intent(this, BagActivity.class);
        startActivity(intent);

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
