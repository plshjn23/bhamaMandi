package com.pernia.ui.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.payu.sdk.PayU;
import com.pernia.R;

import java.util.HashMap;

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


    Button bt_reg;
    @Bind(R.id.main_child_relativr)
    RelativeLayout main_child_relativr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        bt_reg = (Button) findViewById(R.id.bt_register);

        clickListener();
    }

    private void clickListener() {

        bt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double totalString = 200;
                HashMap<String, String> params = new HashMap<String, String>();
                params.put(PayU.TXNID, "0nf7" + System.currentTimeMillis());
                params.put(PayU.PRODUCT_INFO, "product");
                params.put(PayU.USER_CREDENTIALS, "xxxxx:1msdf");
                params.put(PayU.FURL, "https://dl.dropboxusercontent.com/s/1goxkgkx18sg5sm/failure.html");
                params.put(PayU.SURL, "https://dl.dropboxusercontent.com/s/dtnvwz5p4uymjvg/success.html");
                PayU.getInstance(RegistrationActivity.this).startPaymentProcess(totalString, params);
            }
        });
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PayU.RESULT) {
            if (resultCode == RESULT_OK) {
                //success
                if (data != null) {

                    // Toast.makeText(this, "Success" + data.getStringExtra("result"), Toast.LENGTH_LONG).show();

                    Snackbar snackbar = Snackbar.make(main_child_relativr, "Success. Please wait, We are redirecting.", Snackbar.LENGTH_INDEFINITE);
                    View snackView = snackbar.getView();
                    TextView tv = (TextView) snackView.findViewById(android.support.design.R.id.snackbar_text);
                    tv.setTextColor(Color.GREEN);
                    snackbar.show();


                }

            }
            if (resultCode == RESULT_CANCELED) {
                //failed
                if (data != null) {
                    Snackbar snackbar = Snackbar.make(main_child_relativr, "Failed Please try again.", Snackbar.LENGTH_SHORT);
                    View snackView = snackbar.getView();
                    TextView tv = (TextView) snackView.findViewById(android.support.design.R.id.snackbar_text);
                    tv.setTextColor(Color.RED);
                    snackbar.show();
                }
//                    Toast.makeText(this, "Failed" + data.getStringExtra("result"), Toast.LENGTH_LONG).show();
            }
        }
    }

}

