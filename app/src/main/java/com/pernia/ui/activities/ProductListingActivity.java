package com.pernia.ui.activities;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pernia.R;
import com.pernia.ui.adapters.OfferTabAdapter;
import com.pernia.ui.adapters.ProductListAdapter;

import butterknife.Bind;
import butterknife.OnClick;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by Palash on 3/5/2017.
 */
public class ProductListingActivity extends BaseActionbarActivity {


    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.search_image_view)
    TextView mSearchImageView;
    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;
    @Bind(R.id.product_list_recycler_view)
    RecyclerView mProductListRecyclerView;
    GridLayoutManager gridLayoutManager;
    FloatingActionButton fab;
    @Bind(R.id.follow_following_view_stub)
    ViewStub mFilterViewStub;
    String mFilter = "";
    View mViewStubView;
    private LinearLayout filter_linear_layout;
    private ProductListAdapter productListAdapter;
    private boolean isViewStubVisible = false;


    private RelativeLayout create_your_product_or_sell_relative_layout, learn_to_develop, become_tutor1, learn_to_develop1, create_your_product_or_sell_relative_layout1, become_tutor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


        mToolbarTitle.setText("All Products");

        fab = (FloatingActionButton) findViewById(R.id.fab);

        gridLayoutManager = new GridLayoutManager(this, 2);
        productListAdapter = new ProductListAdapter(this);
        mProductListRecyclerView.setLayoutManager(gridLayoutManager);
        mProductListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mProductListRecyclerView.setAdapter(productListAdapter);
        mProductListRecyclerView.setNestedScrollingEnabled(false);


        mViewStubView = mFilterViewStub.inflate();


        showStub();

        clickListenrs();

    }

    private void clickListenrs() {

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ProductListingActivity.this, UploadYourProduct.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected int getActivityLayout() {
        return R.layout.activity_product_listing;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                if (isViewStubVisible) {
                    mFilterViewStub.setVisibility(GONE);
                    isViewStubVisible = false;
                    Log.e("hello", "palash");
                } else {
                    finish();
                }

                break;
        }
        return true;

    }

    private void showStub() {


        filter_linear_layout = (LinearLayout) mViewStubView.findViewById(R.id.filter_linear_layout);
        create_your_product_or_sell_relative_layout = (RelativeLayout) mViewStubView.findViewById(R.id.create_your_product_or_sell_relative_layout);
        learn_to_develop = (RelativeLayout) mViewStubView.findViewById(R.id.learn_to_develop);


        become_tutor = (RelativeLayout) mViewStubView.findViewById(R.id.become_tutor);
        create_your_product_or_sell_relative_layout1 = (RelativeLayout) mViewStubView.findViewById(R.id.create_your_product_or_sell_relative_layout1);


        learn_to_develop1 = (RelativeLayout) mViewStubView.findViewById(R.id.learn_to_develop1);
        become_tutor1 = (RelativeLayout) mViewStubView.findViewById(R.id.become_tutor1);


        filter_linear_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (isViewStubVisible) {
                    mFilterViewStub.setVisibility(GONE);
                    isViewStubVisible = false;
                    Log.e("hello", "palash");
                }
            }
        });


        create_your_product_or_sell_relative_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mToolbarTitle.setText("Painting Products");
                mFilterViewStub.setVisibility(GONE);
                isViewStubVisible = false;
                Log.e("hello", "palash");

            }
        });

        learn_to_develop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mToolbarTitle.setText("Pottery Products");
                mFilterViewStub.setVisibility(GONE);
                isViewStubVisible = false;
                Log.e("hello", "palash");
            }
        });


        become_tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mToolbarTitle.setText("Fashion Products");
                mFilterViewStub.setVisibility(GONE);
                isViewStubVisible = false;
                Log.e("hello", "palash");
            }
        });

        create_your_product_or_sell_relative_layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mToolbarTitle.setText("Food Products");
                mFilterViewStub.setVisibility(GONE);
                isViewStubVisible = false;
                Log.e("hello", "palash");
            }
        });

        learn_to_develop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mToolbarTitle.setText("Metal Products");
                mFilterViewStub.setVisibility(GONE);
                isViewStubVisible = false;
                Log.e("hello", "palash");
            }
        });

        become_tutor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mToolbarTitle.setText("All Products");
                mFilterViewStub.setVisibility(GONE);
                isViewStubVisible = false;
                Log.e("hello", "palash");
            }
        });

        mFilterViewStub.setVisibility(GONE);
    }


    @OnClick(R.id.search_image_view)
    void filter() {

        if (isViewStubVisible) {

            mFilterViewStub.setVisibility(GONE);
            isViewStubVisible = false;
            Log.e("hello", "palash");
        } else {
            isViewStubVisible = true;
            Log.e("hello", "palash1");
            mFilterViewStub.setVisibility(VISIBLE);

        }
    }

}
