package com.pernia.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.pernia.R;
import com.pernia.ui.adapters.ExpandableListAdapterHome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gaurav on 1/3/17.
 */

public class HomeTabFragment extends Fragment {


    ExpandableListAdapterHome listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<Integer>> listDataChild;
    boolean mFirsttime = true;
    private int lastExpandedPosition = -1;

    public HomeTabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_tab, null);

        expListView = (ExpandableListView) rootView.findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

//        listAdapter = new ExpandableListAdapterHome(getActivity(), listDataHeader, listDataChild);
//
//        // setting list adapter
//        expListView.setAdapter(listAdapter);
//            expListView.expandGroup(0);


//        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                if (lastExpandedPosition != -1
//                        && groupPosition != lastExpandedPosition) {
//                    expListView.collapseGroup(lastExpandedPosition);
//                }
//                lastExpandedPosition = groupPosition;
//                if (mFirsttime) {
//                    expListView.collapseGroup(0);
//                    mFirsttime = false;
//                }
//            }
//        });

        return rootView;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Integer>>();

        // Adding child data
        listDataHeader.add("What's New");
        listDataHeader.add("Designers");
        listDataHeader.add("Clothing");
        listDataHeader.add("Acessories");

        // Adding child data
        List<Integer> whatsnew = new ArrayList<Integer>();
        whatsnew.add(R.drawable.image_dummy);


        List<Integer> designers = new ArrayList<Integer>();
        designers.add(R.drawable.image_dummy);

        List<Integer> clothing = new ArrayList<Integer>();
        clothing.add(R.drawable.image_dummy);

        List<Integer> acessories = new ArrayList<Integer>();
        acessories.add(R.drawable.image_dummy);

        listDataChild.put(listDataHeader.get(0), whatsnew); // Header, Child data
        listDataChild.put(listDataHeader.get(1), designers);
        listDataChild.put(listDataHeader.get(2), clothing);
        listDataChild.put(listDataHeader.get(3), acessories);
    }

}
