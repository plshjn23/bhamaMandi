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
import android.widget.TextView;

import com.pernia.R;
import com.pernia.ui.customlayout.NonScrollableExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

import static android.view.View.GONE;

/**
 * Created by om on 3/20/2017.
 */

public class TakeCourseActivity extends BaseActionbarActivity {

    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    ExpandableListAdapterHomeTake listAdapter;

    @Bind(R.id.lvExp)
    NonScrollableExpandableListView expListView;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;
    @Bind(R.id.search_image_view)
    TextView mSearchImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSearchImageView.setVisibility(GONE);
        prepareListData();

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


        mToolbarTitle.setText("Course Content");
        listAdapter = new ExpandableListAdapterHomeTake(this, listDataHeader, listDataChild);
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

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_take_course;
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
        listDataHeader.add("Week #6");
        listDataHeader.add("Week #7");
        listDataHeader.add("Week #8");
        listDataHeader.add("Practice quizzes");
        listDataHeader.add("Required quizzes");
        listDataHeader.add("Assignments");

        // Adding child data
        List<String> week1 = new ArrayList<String>();
        week1.add("Chapter 1");
        week1.add("Chapter 2");
        week1.add("Chapter 3");
        week1.add("Chapter 4");


        List<String> week2 = new ArrayList<String>();
        week2.add("Chapter 1");
        week2.add("Chapter 2");
        week2.add("Chapter 3");
        week2.add("Chapter 4");

        List<String> week3 = new ArrayList<String>();
        week3.add("Chapter 1");
        week3.add("Chapter 2");
        week3.add("Chapter 3");
        week3.add("Chapter 4");


        List<String> week4 = new ArrayList<String>();
        week4.add("Chapter 1");
        week4.add("Chapter 2");
        week4.add("Chapter 3");
        week4.add("Chapter 4");

        List<String> week5 = new ArrayList<String>();
        week5.add("Chapter 1");
        week5.add("Chapter 2");
        week5.add("Chapter 3");
        week5.add("Chapter 4");


        List<String> week6 = new ArrayList<String>();
        week6.add("Chapter 1");
        week6.add("Chapter 2");
        week6.add("Chapter 3");
        week6.add("Chapter 4");

        List<String> week7 = new ArrayList<String>();
        week7.add("Chapter 1");
        week7.add("Chapter 2");
        week7.add("Chapter 3");
        week7.add("Chapter 4");

        List<String> week8 = new ArrayList<String>();
        week8.add("Chapter 1");
        week8.add("Chapter 2");
        week8.add("Chapter 3");
        week8.add("Chapter 4");


        List<String> Practicequizzes = new ArrayList<String>();
        Practicequizzes.add("practice quiz 1");
        Practicequizzes.add("practice quiz 2");
        Practicequizzes.add("practice quiz 3");
        Practicequizzes.add("practice quiz 4");

        List<String> requiredquizzes = new ArrayList<String>();
        requiredquizzes.add("required quiz 1");
        requiredquizzes.add("required quiz 2");
        requiredquizzes.add("required quiz 3");
        requiredquizzes.add("required quiz 4");

        List<String> Assignments = new ArrayList<String>();
        Assignments.add("Assignment 1");
        Assignments.add("Assignment 2");
        Assignments.add("Assignment 3");
        Assignments.add("Assignment 4");

        listDataChild.put(listDataHeader.get(0), week1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), week2);
        listDataChild.put(listDataHeader.get(2), week3);
        listDataChild.put(listDataHeader.get(3), week4);
        listDataChild.put(listDataHeader.get(4), week5); // Header, Child data
        listDataChild.put(listDataHeader.get(5), week6);
        listDataChild.put(listDataHeader.get(6), week7);
        listDataChild.put(listDataHeader.get(7), week8);
        listDataChild.put(listDataHeader.get(8), Practicequizzes);
        listDataChild.put(listDataHeader.get(9), requiredquizzes);
        listDataChild.put(listDataHeader.get(10), Assignments);
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
