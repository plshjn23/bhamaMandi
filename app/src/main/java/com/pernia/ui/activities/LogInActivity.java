package com.pernia.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.pernia.R;

import butterknife.Bind;
import butterknife.OnClick;


/**
 * Created by gaurav on 2/3/17.
 */

public class LogInActivity extends BaseActionbarActivity {
    @Bind(R.id.bt_login)
    Button bt_login;

    @Bind(R.id.skip_text_view)
    TextView skipTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @OnClick(R.id.bt_login)
    public void homeActivity() {
        Intent intent = new Intent(LogInActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }


    @OnClick(R.id.skip_text_view)
    public void homeActivity1() {
        Intent intent = new Intent(LogInActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.login_activity;
    }

}
