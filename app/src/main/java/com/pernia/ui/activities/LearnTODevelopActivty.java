package com.pernia.ui.activities;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pernia.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by om on 3/10/2017.
 */

public class LearnTODevelopActivty extends BaseActionbarActivity {


    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;
    @Bind(R.id.search_image_view)
    TextView mSearchImageView;
    @Bind(R.id.follow_following_view_stub)
    ViewStub mFilterViewStub;
    View mViewStubView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private boolean isViewStubVisible = false;
    private RelativeLayout create_your_product_or_sell_relative_layout, learn_to_develop, become_tutor1, learn_to_develop1, create_your_product_or_sell_relative_layout1, become_tutor;

    private LinearLayout filter_linear_layout;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


        mToolbarTitle.setText("Select A Course");


        mViewStubView = mFilterViewStub.inflate();


        showStub();


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }


    @Override
    protected int getActivityLayout() {
        return R.layout.activity_learn_to_develop;
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FreeFragment(), "Free");
        adapter.addFragment(new PaidFragment(), "Paid");
        viewPager.setAdapter(adapter);
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
                mToolbarTitle.setText("Painting Courses");
                mFilterViewStub.setVisibility(GONE);
                isViewStubVisible = false;
                Log.e("hello", "palash");

            }
        });

        learn_to_develop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mToolbarTitle.setText("Pottery Designing Courses");
                mFilterViewStub.setVisibility(GONE);
                isViewStubVisible = false;
                Log.e("hello", "palash");
            }
        });


        become_tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mToolbarTitle.setText("Fashion Designing Courses");
                mFilterViewStub.setVisibility(GONE);
                isViewStubVisible = false;
                Log.e("hello", "palash");
            }
        });

        create_your_product_or_sell_relative_layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mToolbarTitle.setText("Food Preparation Courses");
                mFilterViewStub.setVisibility(GONE);
                isViewStubVisible = false;
                Log.e("hello", "palash");
            }
        });

        learn_to_develop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mToolbarTitle.setText("Metal Designing Courses");
                mFilterViewStub.setVisibility(GONE);
                isViewStubVisible = false;
                Log.e("hello", "palash");
            }
        });

        become_tutor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mToolbarTitle.setText("Select A Course");
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

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
