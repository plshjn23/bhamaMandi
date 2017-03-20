package com.pernia.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pernia.R;


/**
 * Created by om on 3/20/2017.
 */

class OfferTabAdapterEnrolled extends RecyclerView.Adapter<OfferTabAdapterEnrolled.MyViewHolder> {
    Activity activity;

    public OfferTabAdapterEnrolled(EnrolledCoursesActivity fragmentActivity) {
        this.activity = fragmentActivity;

    }

    @Override
    public OfferTabAdapterEnrolled.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_free_courses, parent, false);

        return new OfferTabAdapterEnrolled.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OfferTabAdapterEnrolled.MyViewHolder holder, int position) {


//        Glide.with(activity).load(bm.getImgUrl()).placeholder(R.drawable.placeholder_brand).dontAnimate()
//                .into(holder.user_profile_pic_image_view);


        holder.free_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(activity, TakeCourseActivity.class);
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