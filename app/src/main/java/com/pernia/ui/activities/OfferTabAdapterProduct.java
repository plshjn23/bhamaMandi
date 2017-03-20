package com.pernia.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pernia.R;
import com.pernia.ui.adapters.ProductListAdapter;

/**
 * Created by om on 3/21/2017.
 */

public class OfferTabAdapterProduct extends RecyclerView.Adapter<OfferTabAdapterProduct.MyViewHolder> {
    Activity activity;

    public OfferTabAdapterProduct(FragmentActivity productListingActivity) {
        this.activity = productListingActivity;

    }

    @Override
    public OfferTabAdapterProduct.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_product_list, parent, false);

        return new OfferTabAdapterProduct.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OfferTabAdapterProduct.MyViewHolder holder, int position) {


//        Glide.with(activity).load(bm.getImgUrl()).placeholder(R.drawable.placeholder_brand).dontAnimate()
//                .into(holder.user_profile_pic_image_view);


        holder.main_relative_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ProductDetailActivity.class);
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

//    public void update(ArrayList<BrandsModel> brandsModels) {
//
//        this.brandsModels = brandsModels;
//        notifyDataSetChanged();
//    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout main_relative_layout;

        public MyViewHolder(View view) {
            super(view);
//            id = (TextView) view.findViewById(R.id.id);
            main_relative_layout = (RelativeLayout) view.findViewById(R.id.main_relative_layout);

        }
    }
}