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

/**
 * Created by om on 3/21/2017.
 */

public class ProductFragment extends Fragment {
    RecyclerView mOfferTabRecyclerView;
    GridLayoutManager gridLayoutManager;
    private OfferTabAdapterProduct offerTabAdapter;

    public ProductFragment() {
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

        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        offerTabAdapter = new OfferTabAdapterProduct(getActivity());
        mOfferTabRecyclerView.setLayoutManager(gridLayoutManager);
        mOfferTabRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mOfferTabRecyclerView.setAdapter(offerTabAdapter);
        mOfferTabRecyclerView.setNestedScrollingEnabled(false);

        return rootView;
    }
}

