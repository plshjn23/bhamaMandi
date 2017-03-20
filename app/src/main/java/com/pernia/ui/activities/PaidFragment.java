package com.pernia.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pernia.R;
import com.pernia.ui.adapters.OfferTabAdapter;

/**
 * Created by om on 3/10/2017.
 */

public class PaidFragment extends Fragment {
    RecyclerView mOfferTabRecyclerView;
    GridLayoutManager gridLayoutManager;
    private OfferTabAdapterPaid offerTabAdapter;

    public PaidFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_offer_tab, null);


        mOfferTabRecyclerView = (RecyclerView) rootView.findViewById(R.id.offers_recycler_view);

        RecyclerView.LayoutManager mLayoutManagerTopBrands = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        offerTabAdapter = new OfferTabAdapterPaid(getActivity());
        mOfferTabRecyclerView.setLayoutManager(mLayoutManagerTopBrands);
        mOfferTabRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mOfferTabRecyclerView.setAdapter(offerTabAdapter);
        mOfferTabRecyclerView.setNestedScrollingEnabled(false);

        return rootView;
    }
}
