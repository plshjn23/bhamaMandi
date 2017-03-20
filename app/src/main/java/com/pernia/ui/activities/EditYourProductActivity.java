package com.pernia.ui.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pernia.R;

import butterknife.Bind;
import butterknife.OnClick;

import static com.pernia.ui.activities.MyShopActivity.main_relative;

/**
 * Created by om on 3/20/2017.
 */

public class EditYourProductActivity extends BaseActionbarActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.search_image_view)
    TextView mSearchImageView;
    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;
    @Bind(R.id.proceed_to_pay_button)
    Button upload;
    @Bind(R.id.main_relative)
    RelativeLayout main_relative;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


        mToolbarTitle.setText("Edit your product");

        mSearchImageView.setText(R.string.fa_cart);
    }

    @OnClick(R.id.search_image_view)
    public void jumpToSearch() {
        Intent intent = new Intent(this, BagActivity.class);
        startActivity(intent);
    }


    @OnClick(R.id.proceed_to_pay_button)
    public void jumpTomyShop() {
        Snackbar snackbar = Snackbar
                .make(main_relative, "Product edited and submitted successfully", Snackbar.LENGTH_LONG);

        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.GREEN);
        snackbar.show();
        finish();
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_edit_your_product;
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
