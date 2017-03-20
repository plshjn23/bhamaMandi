package com.pernia.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pernia.R;
import com.pernia.ui.adapters.BagTabAdapter;
import com.pernia.ui.adapters.OfferTabAdapter;

/**
 * Created by Palash on 1/3/17.
 */

public class BagTabFragment extends Fragment {

    RecyclerView mBagTabRecyclerView;

    private BagTabAdapter bagTabAdapter;


    public BagTabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bag_tab, null);


        mBagTabRecyclerView = (RecyclerView) rootView.findViewById(R.id.bag_recycler_view);

        RecyclerView.LayoutManager mLayoutManagerTopBrands = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        bagTabAdapter = new BagTabAdapter(getActivity());
        mBagTabRecyclerView.setLayoutManager(mLayoutManagerTopBrands);
        mBagTabRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mBagTabRecyclerView.setAdapter(bagTabAdapter);
        mBagTabRecyclerView.setNestedScrollingEnabled(false);

        return rootView;
    }
}
