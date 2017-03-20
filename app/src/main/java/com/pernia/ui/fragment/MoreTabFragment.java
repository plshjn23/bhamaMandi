package com.pernia.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pernia.R;
import com.pernia.ui.activities.ContactUsActivity;
import com.pernia.ui.activities.MyAccountActivity;

/**
 * Created by gaurav on 1/3/17.
 */

public class MoreTabFragment extends Fragment {

    RelativeLayout mMyAccountRelativeLayout, mContactUsRelativeLayout;


    public MoreTabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_more_tab, null);


        mMyAccountRelativeLayout = (RelativeLayout) rootView.findViewById(R.id.my_account_relative_layout);
        mContactUsRelativeLayout = (RelativeLayout) rootView.findViewById(R.id.contact_us_relative_layout);

        clickListeners();


        return rootView;
    }

    private void clickListeners() {


        mMyAccountRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), MyAccountActivity.class);
                startActivity(intent);
            }
        });

        mContactUsRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ContactUsActivity.class);
                startActivity(intent);
            }
        });
    }
}
