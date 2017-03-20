package com.pernia.ui.activities;

import android.content.Intent;
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
import butterknife.OnClick;

/**
 * Created by om on 3/4/2017.
 */

public class MyAccountActivity extends BaseActionbarActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.search_image_view)
    TextView mSearchImageView;

    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        mToolbarTitle.setText("My Profile");
        mSearchImageView.setText(R.string.fa_cart);
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_my_account;
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

    @OnClick(R.id.search_image_view)
    public void jumpToSearch() {
        Intent intent = new Intent(this, BagActivity.class);
        startActivity(intent);

    }
}
