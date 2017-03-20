package com.pernia.ui.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pernia.R;
import com.pernia.ui.activities.ProductDetailActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductDetailExpandableListAdapter extends BaseExpandableListAdapter  {
    Context context;
    ArrayList<String> parentArrayList = new ArrayList<>();
    HashMap<String, ArrayList<String>> detailHashMap = new HashMap<>();
    String headerTitle;


    public ProductDetailExpandableListAdapter(Context mcontext, ArrayList<String> parentArrayList, HashMap<String, ArrayList<String>> detailHashMap) {

        this.context=mcontext;
        this.parentArrayList=parentArrayList;
        this.detailHashMap=detailHashMap;
    }

    @Override
    public int getGroupCount() {
        return parentArrayList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentArrayList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return detailHashMap.get(parentArrayList.get(groupPosition)).get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        headerTitle = (String) getGroup(groupPosition);

        ParentViewHOlder holder;

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.adapter_product_detail_list_item_header, parent, false);
            holder = new ParentViewHOlder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ParentViewHOlder) convertView.getTag();
        }
        holder.headerTv.setText(headerTitle);
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final ChildViewHolder holder;
        String childText = (String) getChild(groupPosition, childPosition);
        final int mGroupPosition = groupPosition;
        final int mChildPosition = childPosition;
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.adapter_product_detail_list_child_item, parent, false);
            holder = new ChildViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ChildViewHolder) convertView.getTag();
        }
        holder.childTv.setText(childText);


        return convertView;
    }



    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }



    public class ChildViewHolder {
        TextView childTv;

        ChildViewHolder(View view) {

            childTv= (TextView) view.findViewById(R.id.tv_child);
        }
    }

    public class ParentViewHOlder {
        TextView headerTv;
        LinearLayout titleLL;

        ParentViewHOlder(View view) {

            headerTv= (TextView) view.findViewById(R.id.tv_header);

        }
    }

    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }
}

