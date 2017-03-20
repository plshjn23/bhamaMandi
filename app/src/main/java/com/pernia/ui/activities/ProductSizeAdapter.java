package com.pernia.ui.activities;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pernia.R;
import com.pernia.ui.activities.ProductDetailActivity;

/**
 * Created by gaurav on 8/3/17.
 */

public class ProductSizeAdapter extends RecyclerView.Adapter<ProductSizeAdapter.MyViewHolder> {
    Context mcontext;
    public ProductSizeAdapter(Context context) {
        this.mcontext=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view=  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_size_chart_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.rl_size.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    holder.tv_size.setTextColor(ContextCompat.getColor(mcontext,R.color.colorAccent));
                    holder.tv_size.setTypeface(null,Typeface.BOLD);
                }
                else{
                    holder.tv_size.setTextColor(ContextCompat.getColor(mcontext,R.color.secondary_dark_grey));
                    holder.tv_size.setTypeface(null,Typeface.NORMAL);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout rl_size;
        TextView tv_size;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_size= (TextView) itemView.findViewById(R.id.tv_size);
            rl_size= (RelativeLayout) itemView.findViewById(R.id.rl_size);
        }
    }
}
