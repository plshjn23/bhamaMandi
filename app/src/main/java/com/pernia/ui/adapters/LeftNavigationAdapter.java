package com.pernia.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pernia.R;

import java.util.ArrayList;

/**
 * Created by om on 3/5/2017.
 */
public class LeftNavigationAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> drawerItemsArrayList;
    private LayoutInflater inflater;

    public LeftNavigationAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);


        drawerItemsArrayList = new ArrayList<>();
        drawerItemsArrayList.add("What's New");
        drawerItemsArrayList.add("Designer's");
        drawerItemsArrayList.add("Clothing");
        drawerItemsArrayList.add("Accessories");
        drawerItemsArrayList.add("Men's Shop");
        drawerItemsArrayList.add("Celebrity Closet");
        drawerItemsArrayList.add("Magazine");
        drawerItemsArrayList.add("Fashion Week");
        drawerItemsArrayList.add("Sale");
        drawerItemsArrayList.add("Newsletter");
    }

    @Override
    public int getCount() {
        return drawerItemsArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        final MyViewHolder myViewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.view_single_row_drawer_items, viewGroup, false);
            myViewHolder = new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        myViewHolder.tvItemName.setText(drawerItemsArrayList.get(position));

        return convertView;
    }

    private class MyViewHolder {

        TextView tvItemName;
        ImageView ivItemImage;
        LinearLayout parentLayout;

        public MyViewHolder(View view) {
            tvItemName = (TextView) view.findViewById(R.id.tv_drawer_item_name);
            parentLayout = (LinearLayout) view.findViewById(R.id.parent_layout);
            ivItemImage = (ImageView) view.findViewById(R.id.image_drawer_image_view);
        }

    }
}
