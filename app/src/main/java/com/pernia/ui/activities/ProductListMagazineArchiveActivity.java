package com.pernia.ui.activities;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.pernia.R;
import com.pernia.ui.adapters.ProductListAdapter;
import com.pernia.ui.adapters.ProductListMagzineAdapter;

import butterknife.Bind;

/**
 * Created by Palash on 3/5/2017.
 */

public class ProductListMagazineArchiveActivity extends BaseActionbarActivity {

    public static String mwhereItComeFrom = "";
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.search_image_view)
    ImageView mSearchImageView;
    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;
    @Bind(R.id.product_list_magazine_archive_recycler_view)
    RecyclerView mProductListRecyclerView;
    GridLayoutManager gridLayoutManager;
    private ProductListMagzineAdapter productListMagazineAdapter;


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

            mToolbarTitle.setText("Magazine");
        }

        gridLayoutManager = new GridLayoutManager(this, 3);
        productListMagazineAdapter = new ProductListMagzineAdapter(this);
        mProductListRecyclerView.setLayoutManager(gridLayoutManager);
        mProductListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mProductListRecyclerView.setAdapter(productListMagazineAdapter);
        mProductListRecyclerView.setNestedScrollingEnabled(false);

    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_product_list_magazine_archive;
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
