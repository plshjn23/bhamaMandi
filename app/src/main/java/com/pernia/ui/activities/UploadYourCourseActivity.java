package com.pernia.ui.activities;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.pernia.R;

import butterknife.Bind;
import butterknife.OnClick;

import static android.view.View.GONE;

/**
 * Created by om on 3/10/2017.
 */

public class UploadYourCourseActivity extends BaseActionbarActivity {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.search_image_view)
    TextView mSearchImageView;
    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;
    @Bind(R.id.proceed_to_pay_button)
    Button upload;

    @Bind(R.id.free_radio)
    RadioButton free_radio;
    @Bind(R.id.paid_radio)
    RadioButton paid_radio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


        mToolbarTitle.setText("Upload Your Course");

        mSearchImageView.setVisibility(GONE);
    }


    @OnClick(R.id.free_radio)
    void freeclick() {
        free_radio.setChecked(true);
        paid_radio.setChecked(false);

    }

    @OnClick(R.id.paid_radio)
    void paidClick() {

        free_radio.setChecked(false);
        paid_radio.setChecked(true);

    }

    @OnClick(R.id.proceed_to_pay_button)
    public void jumpTomyShop() {
        Intent intent = new Intent(this, NextUoloadYourCourseActivity.class);
        startActivity(intent);

    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_upload_course;
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
