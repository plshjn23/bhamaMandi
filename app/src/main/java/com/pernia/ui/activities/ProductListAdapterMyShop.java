package com.pernia.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.pernia.R;

import android.widget.TextView;
import android.app.Dialog;
import android.view.View.OnClickListener;

import static com.pernia.ui.activities.MyShopActivity.main_relative;


/**
 * Created by om on 3/10/2017.
 */

class ProductListAdapterMyShop extends RecyclerView.Adapter<ProductListAdapterMyShop.MyViewHolder> {
    Activity activity;

    public ProductListAdapterMyShop(MyShopActivity productListingActivity) {
        this.activity = productListingActivity;

    }

    @Override
    public ProductListAdapterMyShop.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_product_list_my_shop, parent, false);

        return new ProductListAdapterMyShop.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductListAdapterMyShop.MyViewHolder holder, int position) {


        holder.remove_product_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Create custom dialog object
                final Dialog dialog = new Dialog(activity);
                // Include dialog.xml file
                dialog.setContentView(R.layout.dialog_remove_product);
                // Set dialog title
                dialog.setTitle("");

                // set values for custom dialog components - text, image and button

                dialog.show();

                Button declineButton = (Button) dialog.findViewById(R.id.cancel_button);
                // if decline button is clicked, close the custom dialog
                declineButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Close dialog
                        dialog.dismiss();
                    }
                });

                Button delete_button = (Button) dialog.findViewById(R.id.delete_button);
                delete_button.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Close dialog
                        Snackbar snackbar = Snackbar
                                .make(main_relative, "Product Deleted Successfully", Snackbar.LENGTH_LONG);

                        View sbView = snackbar.getView();
                        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                        textView.setTextColor(Color.GREEN);
                        snackbar.show();
                        dialog.dismiss();
                    }
                });


            }
        });

        holder.edit_product_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, EditYourProductActivity.class);
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        Button edit_product_button;
        ImageView remove_product_image_view;

        public MyViewHolder(View view) {
            super(view);
            edit_product_button = (Button) view.findViewById(R.id.edit_product_button);
            remove_product_image_view = (ImageView) view.findViewById(R.id.remove_product_image_view);

        }
    }
}