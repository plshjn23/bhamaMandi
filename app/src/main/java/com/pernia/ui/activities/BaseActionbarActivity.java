package com.pernia.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Palash on 03-02-2017.
 */
public abstract class BaseActionbarActivity extends AppCompatActivity {


    private final String TAG = BaseActionbarActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayout());
        ButterKnife.bind(this);

    }

    protected abstract int getActivityLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


}
