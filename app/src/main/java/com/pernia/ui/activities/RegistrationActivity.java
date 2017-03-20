package com.pernia.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;

import com.pernia.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by gaurav on 2/3/17.
 */

public class RegistrationActivity extends BaseActionbarActivity {

    @Bind(R.id.cb_term)
    RadioButton cb_term;

    @Bind(R.id.cb_email)
    RadioButton cb_email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getActivityLayout() {
        return R.layout.register_activity;
    }


    @OnClick(R.id.cb_term)
    void cb() {
        cb_term.setChecked(true);
        if (cb_email.isChecked()) {
            cb_email.setChecked(false);
        }
    }

    @OnClick(R.id.cb_email)
    void ema() {
        cb_email.setChecked(true);
        if (cb_term.isChecked()) {
            cb_term.setChecked(false);
        }
    }
}
