package com.pernia.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pernia.R;
import com.pernia.ui.fragment.NavigationFragment;

import butterknife.Bind;
import butterknife.OnClick;

import static android.view.View.GONE;

public class HomeActivity extends BaseActionbarActivity {


    protected DrawerLayout drawerLayout;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.search_image_view)
    TextView mSearchImageView;

    @Bind(R.id.create_your_product_or_sell_relative_layout)
    RelativeLayout createYourProduct;
    @Bind(R.id.learn_to_develop)
    RelativeLayout learn_to_develop;
    @Bind(R.id.become_tutor)
    RelativeLayout become_tutor;
    private Toolbar toolbar;
    private ListView navigationLV;
    private NavigationFragment mNavigationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mSearchImageView.setText(R.string.fa_cart);


    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_main;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);  // OPEN DRAWER
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void initViews() {
        navigationLV = (ListView) findViewById(R.id.listview_navigation_drawer);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationFragment = (NavigationFragment) getSupportFragmentManager().findFragmentById(R.id.navFragment);
        mNavigationFragment.setUp(R.id.navFragment, drawerLayout, toolbar);

    }


    @OnClick(R.id.search_image_view)
    public void jumpToSearch() {
        Intent intent = new Intent(this, BagActivity.class);
        startActivity(intent);

    }

    @OnClick(R.id.create_your_product_or_sell_relative_layout)
    public void jumpTobuy() {
        Intent intent = new Intent(this, ProductListingActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.learn_to_develop)
    public void learn_to_develop() {
        Intent intent = new Intent(this, LearnTODevelopActivty.class);
        startActivity(intent);
    }

    @OnClick(R.id.become_tutor)
    public void becomeTutor() {

        Intent intent = new Intent(this, UploadYourCourseActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {

        super.onResume();
    }
}
