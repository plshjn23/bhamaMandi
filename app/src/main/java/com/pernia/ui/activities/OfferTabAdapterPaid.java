package com.pernia.ui.activities;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pernia.R;
import com.pernia.ui.adapters.OfferTabAdapter;

/**
 * Created by om on 3/20/2017.
 */

class OfferTabAdapterPaid extends RecyclerView.Adapter<OfferTabAdapterPaid.MyViewHolder> {
    Activity activity;

    public OfferTabAdapterPaid(FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;

    }

    @Override
    public OfferTabAdapterPaid.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_paid_courses, parent, false);

        return new OfferTabAdapterPaid.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OfferTabAdapterPaid.MyViewHolder holder, int position) {


//        Glide.with(activity).load(bm.getImgUrl()).placeholder(R.drawable.placeholder_brand).dontAnimate()
//                .into(holder.user_profile_pic_image_view);


    }

    @Override
    public int getItemCount() {
        return 15;
    }

//    public void update(ArrayList<BrandsModel> brandsModels) {
//
//        this.brandsModels = brandsModels;
//        notifyDataSetChanged();
//    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View view) {
            super(view);
//            id = (TextView) view.findViewById(R.id.id);

        }
    }
}