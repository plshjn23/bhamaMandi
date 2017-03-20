package com.pernia.ui.activities;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pernia.R;

/**
 * Created by om on 3/10/2017.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder> {
    Activity activity;

    public CategoriesAdapter(AllCategoriesActivity homeActivity) {
        this.activity = homeActivity;

    }

    @Override
    public CategoriesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_categories_recycler_view, parent, false);

        return new CategoriesAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoriesAdapter.MyViewHolder holder, int position) {


//        Glide.with(activity).load(bm.getImgUrl()).placeholder(R.drawable.placeholder_brand).dontAnimate()
//                .into(holder.user_profile_pic_image_view);
//        holder.brand_name_text_view.setText(bm.getTitle());


    }

    @Override
    public int getItemCount() {
        return 3;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
//        CircleImageView user_profile_pic_image_view;
//        TextView brand_name_text_view;
//        RelativeLayout view_notification_relative_layout;


        public MyViewHolder(View view) {
            super(view);
//            id = (TextView) view.findViewById(R.id.id);
//            user_profile_pic_image_view = (CircleImageView) view.findViewById(R.id.user_profile_pic_image_view);
//            brand_name_text_view = (TextView) view.findViewById(R.id.brand_name_text_view);
//            view_notification_relative_layout = (RelativeLayout) view.findViewById(R.id.view_notification_relative_layout);

        }
    }
}