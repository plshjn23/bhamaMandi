package com.pernia.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pernia.R;
import com.pernia.ui.activities.BookmarkedCoursesActivity;
import com.pernia.ui.activities.ContactUsActivity;
import com.pernia.ui.activities.EnrolledCoursesActivity;
import com.pernia.ui.activities.LangagugeActivity;
import com.pernia.ui.activities.MyAccountActivity;
import com.pernia.ui.activities.MyShopActivity;
import com.pernia.ui.activities.TransactionActivity;

/**
 * Created by om on 3/10/2017.
 */

public class NavigationFragment extends Fragment {


    private ListView listView;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private View containerView, view;
    private DrawerAdapter drawerAdapter;
    private Intent intent;
    private Context context;

    public NavigationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.view_fragment_navigation, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getActivity();

        //   String user_pic=preferences1.getString("user_pic","");
        listView = (ListView) view.findViewById(R.id.listview_navigation_drawer);
        drawerAdapter = new DrawerAdapter(view.getContext());
        listView.setAdapter(drawerAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {
                switch (position) {

                    case 0:
                        Intent intent = new Intent(getActivity(), MyAccountActivity.class);
                        getActivity().startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(), TransactionActivity.class);
                        getActivity().startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(), LangagugeActivity.class);
                        getActivity().startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(), EnrolledCoursesActivity.class);
                        getActivity().startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getActivity(), BookmarkedCoursesActivity.class);
                        getActivity().startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(getActivity(), MyShopActivity.class);
                        getActivity().startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(getActivity(), ContactUsActivity.class);
                        getActivity().startActivity(intent6);
                        break;

                }
            }
        });
    }


    public void setUp(int navFragment, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getView().findViewById(navFragment);
        mDrawerLayout = drawerLayout;


        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, R.string.drawer_open,
                R.string.drawer_close) {

        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }
}



