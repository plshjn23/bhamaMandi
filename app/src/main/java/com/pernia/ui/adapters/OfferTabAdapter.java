package com.pernia.ui.adapters;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pernia.R;
import com.pernia.ui.activities.FreeCourseDetailActivity;

/**
 * Created by Palash on 3/1/2017.
 */
public class OfferTabAdapter extends RecyclerView.Adapter<OfferTabAdapter.MyViewHolder> {
    Activity activity;

    public OfferTabAdapter(FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;

    }

    @Override
    public OfferTabAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_free_courses, parent, false);

        return new OfferTabAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OfferTabAdapter.MyViewHolder holder, int position) {


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