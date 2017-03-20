package com.pernia.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.pernia.R;
import com.tiagosantos.enchantedviewpager.EnchantedViewPager;

/**
 * Created by gaurav on 8/3/17.
 */

public class ProductDetailImageAdapter extends PagerAdapter {
    Context context;
    int[] flag;
    public LayoutInflater inflater;
    int NumberOfPages = 0;

    public ProductDetailImageAdapter(Context context, int[] flag) {
        this.context = context;
        this.flag = flag;
        this.NumberOfPages = flag.length;
    }

    @Override
    public int getCount() {
        return flag.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imgflag;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.product_detail_item, container,
                false);
        itemView.setTag(EnchantedViewPager.ENCHANTED_VIEWPAGER_POSITION + position);
        imgflag = (ImageView) itemView.findViewById(R.id.iv_productimage);
        imgflag.setImageResource(flag[position]);
        imgflag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(context, FullScreenImageActivity.class);
//                context.startActivity(intent);
            }
        });

        ((ViewPager) container).addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);

    }
}
