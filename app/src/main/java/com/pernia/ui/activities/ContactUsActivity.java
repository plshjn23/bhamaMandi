package com.pernia.ui.activities;

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
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.pernia.R;
import com.pernia.ui.fragment.ContactUsFragment;
import com.pernia.ui.fragment.FaqsFragment;
import com.pernia.ui.fragment.HowToShopFragment;
import com.pernia.ui.fragment.PrivacyPolicyFragment;
import com.pernia.ui.fragment.ReturnAndExchangeFragment;
import com.pernia.ui.fragment.ShippingInformationFragment;
import com.pernia.ui.fragment.SizingFragment;
import com.pernia.ui.fragment.TearmsAndConditionsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by om on 3/4/2017.
 */

public class ContactUsActivity extends BaseActionbarActivity {


    @Bind(R.id.tabs)
    TabLayout tabLayout;

    @Bind(R.id.viewpager)
    ViewPager mViewPager;

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

        mToolbarTitle.setText("Customer Care");
        mSearchImageView.setText(R.string.fa_cart);


        setupViewPager(mViewPager);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager mViewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ContactUsFragment(), "Contact Us");
        adapter.addFragment(new HowToShopFragment(), "How To Shop");
        adapter.addFragment(new ShippingInformationFragment(), "Shipping Information");
        adapter.addFragment(new ReturnAndExchangeFragment(), "Return and Exchange");
        adapter.addFragment(new SizingFragment(), "Sizing");
        adapter.addFragment(new FaqsFragment(), "Faqs");
        adapter.addFragment(new TearmsAndConditionsFragment(), "Terms and Conditions");
        adapter.addFragment(new PrivacyPolicyFragment(), "Privacy Policy");
        mViewPager.setAdapter(adapter);
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_contact_us;
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
