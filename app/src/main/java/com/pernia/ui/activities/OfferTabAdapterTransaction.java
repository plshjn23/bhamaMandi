package com.pernia.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pernia.R;


/**
 * Created by om on 3/20/2017.
 */

class OfferTabAdapterTransaction extends RecyclerView.Adapter<OfferTabAdapterTransaction.MyViewHolder> {
    Activity activity;

    public OfferTabAdapterTransaction(TransactionActivity fragmentActivity) {
        this.activity = fragmentActivity;

    }

    @Override
    public OfferTabAdapterTransaction.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_transaction, parent, false);

        return new OfferTabAdapterTransaction.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OfferTabAdapterTransaction.MyViewHolder holder, int position) {


//        Glide.with(activity).load(bm.getImgUrl()).placeholder(R.drawable.placeholder_brand).dontAnimate()
//                .into(holder.user_profile_pic_image_view);
        if (position % 3 == 0) {

            holder.product_by_text_view.setTextColor(activity.getResources().getColor(R.color.stats_green));
        }

    }

    @Override
    public int getItemCount() {
        return 20;
    }

//    public void update(ArrayList<BrandsModel> brandsModels) {
//
//        this.brandsModels = brandsModels;
//        notifyDataSetChanged();
//    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView free_card;
        TextView product_by_text_view;

        public MyViewHolder(View view) {
            super(view);
//            id = (TextView) view.findViewById(R.id.id);
            free_card = (CardView) view.findViewById(R.id.free_card);
            product_by_text_view = (TextView) view.findViewById(R.id.price_by_text_view);
        }
    }
}