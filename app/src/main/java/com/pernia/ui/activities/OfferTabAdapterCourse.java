package com.pernia.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pernia.R;
import com.pernia.ui.adapters.OfferTabAdapter;


/**
 * Created by om on 3/21/2017.
 */

class OfferTabAdapterCourse extends RecyclerView.Adapter<OfferTabAdapterCourse.MyViewHolder> {
    Activity activity;

    public OfferTabAdapterCourse(FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;

    }

    @Override
    public OfferTabAdapterCourse.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_free_courses, parent, false);

        return new OfferTabAdapterCourse.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OfferTabAdapterCourse.MyViewHolder holder, int position) {


//        Glide.with(activity).load(bm.getImgUrl()).placeholder(R.drawable.placeholder_brand).dontAnimate()
//                .into(holder.user_profile_pic_image_view);



        holder.free_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Intent intent = new Intent(activity, FreeCourseDetailActivity.class);
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

        CardView free_card;

        public MyViewHolder(View view) {
            super(view);
//            id = (TextView) view.findViewById(R.id.id);
            free_card = (CardView) view.findViewById(R.id.free_card);
        }
    }
}