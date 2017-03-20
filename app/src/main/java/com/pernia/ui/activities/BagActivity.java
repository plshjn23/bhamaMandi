package com.pernia.ui.activities;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.pernia.R;
import com.pernia.ui.adapters.BagTabAdapter;

import butterknife.Bind;
import butterknife.OnClick;

import static android.view.View.GONE;

/**
 * Created by om on 3/19/2017.
 */

public class BagActivity extends BaseActionbarActivity {


    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.search_image_view)
    TextView mSearchImageView;
    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;

    @Bind(R.id.proceed_to_pay_button)
    Button proceed_to_pay_button;

    RecyclerView mBagTabRecyclerView;
    BagTabAdapter bagTabAdapter;



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

        mToolbarTitle.setText("Shopping Cart");


        mBagTabRecyclerView = (RecyclerView) findViewById(R.id.bag_recycler_view);

        RecyclerView.LayoutManager mLayoutManagerTopBrands = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        bagTabAdapter = new BagTabAdapter(this);
        mBagTabRecyclerView.setLayoutManager(mLayoutManagerTopBrands);
        mBagTabRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mBagTabRecyclerView.setAdapter(bagTabAdapter);
        mBagTabRecyclerView.setNestedScrollingEnabled(false);

    }

    @Override
    protected int getActivityLayout() {
        return R.layout.fragment_bag_tab;
    }

    @OnClick(R.id.proceed_to_pay_button)
    void OnClidj() {
        Intent intent = new Intent(this, RegistrationActivity.class);
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
