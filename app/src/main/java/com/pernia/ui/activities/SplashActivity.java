package com.pernia.ui.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.pernia.R;

import net.bohush.geometricprogressview.GeometricProgressView;


/**
 * Created by gaurav on 2/3/17.
 */

public class SplashActivity extends AppCompatActivity {
    private GeometricProgressView progressView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressView = (GeometricProgressView) findViewById(R.id.progressView);
        progressView.setType(GeometricProgressView.TYPE.TRIANGLE);
        progressView.setNumberOfAngles(3);
        progressView.setColor(ContextCompat.getColor(this, R.color.colorAccent));
        progressView.setDuration(700);
        progressView.setFigurePadding(getResources().getDimensionPixelOffset(R.dimen.figure_padding));
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent it = new Intent(SplashActivity.this, LogInActivity.class);
                        startActivity(it);
                        finish();
                    }
                });

            }
        }).start();

    }


}
