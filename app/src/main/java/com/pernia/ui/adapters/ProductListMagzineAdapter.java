package com.pernia.ui.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pernia.R;
import com.pernia.ui.activities.HomeActivity;
import com.pernia.ui.activities.ProductListMagazineArchiveActivity;
import com.pernia.ui.activities.ProductListingMagazineActivity;


/**
 * Created by Palash on 3/5/2017.
 */
public class ProductListMagzineAdapter extends RecyclerView.Adapter<ProductListMagzineAdapter.MyViewHolder> {
    Activity activity;

    public ProductListMagzineAdapter(ProductListMagazineArchiveActivity productListingActivity) {
        this.activity = productListingActivity;

    }

    @Override
    public ProductListMagzineAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_product_magazine_list, parent, false);

        return new ProductListMagzineAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductListMagzineAdapter.MyViewHolder holder, int position) {


//        Glide.with(activity).load(bm.getImgUrl()).placeholder(R.drawable.placeholder_brand).dontAnimate()
//                .into(holder.user_profile_pic_image_view);


        holder.card_card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentMagazine = new Intent(activity, ProductListingMagazineActivity.class);
                activity.startActivity(intentMagazine);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 21;
    }

//    public void update(ArrayList<BrandsModel> brandsModels) {
//
//        this.brandsModels = brandsModels;
//        notifyDataSetChanged();
//    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView card_card_view;

        public MyViewHolder(View view) {
            super(view);
//            id = (TextView) view.findViewById(R.id.id);
            card_card_view = (CardView) view.findViewById(R.id.card_card_view);

        }
    }
}