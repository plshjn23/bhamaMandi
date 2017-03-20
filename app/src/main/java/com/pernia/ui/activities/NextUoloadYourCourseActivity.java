package com.pernia.ui.activities;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pernia.R;
import com.pernia.ui.adapters.ExpandableListAdapterHome;
import com.pernia.ui.customlayout.NonScrollableExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

import static android.view.View.GONE;

/**
 * Created by om on 3/20/2017.
 */

public class NextUoloadYourCourseActivity extends BaseActionbarActivity {


    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    ExpandableListAdapterNext listAdapter;

    @Bind(R.id.lvExp)
    NonScrollableExpandableListView expListView;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;
    @Bind(R.id.search_image_view)
    TextView mSearchImageView;
    @Bind(R.id.main_child_relativr)
    RelativeLayout main_child_relativr;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prepareListData();

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        mSearchImageView.setVisibility(GONE);

        mToolbarTitle.setText("Upload course content");
        listAdapter = new ExpandableListAdapterNext(this, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setGroupIndicator(null);
        expListView.setChildIndicator(null);
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                setListViewHeight(parent, groupPosition);
                return false;
            }
        });
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_next_upload_activty;
    }

    private void setListViewHeight(ExpandableListView listView,
                                   int group) {
        ExpandableListAdapter listAdapter = (ExpandableListAdapter) listView.getExpandableListAdapter();
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.EXACTLY);
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            View groupItem = listAdapter.getGroupView(i, false, null, listView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

            totalHeight += groupItem.getMeasuredHeight();

            if (((listView.isGroupExpanded(i)) && (i != group))
                    || ((!listView.isGroupExpanded(i)) && (i == group))) {
                for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                    View listItem = listAdapter.getChildView(i, j, false, null,
                            listView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                    totalHeight += listItem.getMeasuredHeight();

                }
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
        if (height < 10)
            height = 200;
        params.height = height;
        listView.setLayoutParams(params);
        listView.requestLayout();

    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Week #1");
        listDataHeader.add("Week #2");
        listDataHeader.add("Week #3");
        listDataHeader.add("Week #4");
        listDataHeader.add("Week #5");

        // Adding child data
        List<String> week1 = new ArrayList<String>();
        week1.add("Chapter 1");


        List<String> week2 = new ArrayList<String>();
        week2.add("Chapter 1");

        List<String> week3 = new ArrayList<String>();
        week3.add("Chapter 1");


        List<String> week4 = new ArrayList<String>();
        week4.add("Chapter 1");

        List<String> week5 = new ArrayList<String>();
        week5.add("Chapter 1");


        listDataChild.put(listDataHeader.get(0), week1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), week2);
        listDataChild.put(listDataHeader.get(2), week3);
        listDataChild.put(listDataHeader.get(3), week4);
        listDataChild.put(listDataHeader.get(4), week5); // Header, Child data
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;

    }
}
