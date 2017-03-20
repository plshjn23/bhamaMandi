package com.pernia.ui.adapters;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pernia.R;

/**
 * Created by Palash on 3/4/2017.
 */
public class BagTabAdapter extends RecyclerView.Adapter<BagTabAdapter.MyViewHolder> {
    Activity activity;

    public BagTabAdapter(FragmentActivity fragmentActivity ) {
        this.activity = fragmentActivity;

    }

    @Override
    public BagTabAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_bag_tab, parent, false);

        return new BagTabAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BagTabAdapter.MyViewHolder holder, int position) {



//        Glide.with(activity).load(bm.getImgUrl()).placeholder(R.drawable.placeholder_brand).dontAnimate()
//                .into(holder.user_profile_pic_image_view);



    }

    @Override
    public int getItemCount() {
        return 2;
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