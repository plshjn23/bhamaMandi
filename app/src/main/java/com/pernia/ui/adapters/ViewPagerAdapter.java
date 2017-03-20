package com.pernia.ui.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.pernia.R;
import com.pernia.ui.activities.ProductListingMagazineActivity;

import java.util.ArrayList;

/**
 * Created by om on 3/5/2017.
 */
public class ViewPagerAdapter extends PagerAdapter {
    Context mcontext;
    ArrayList<Integer> productListModelArrayList;
    LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context, ArrayList<Integer> imageModelArrayList) {
        this.productListModelArrayList = imageModelArrayList;
        this.mcontext = context;
    }

    @Override
    public int getCount() {
        return productListModelArrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {


        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        layoutInflater = (LayoutInflater) mcontext.getSystemService(mcontext.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.view_view_pager_fragment, container, false);
        ImageView imageView;
        imageView = (ImageView) view.findViewById(R.id.image_image_view);

        imageView.setImageResource(productListModelArrayList.get(position));

        ((ViewPager) container).addView(view);

        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);
    }
}
