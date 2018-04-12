package com.example.a501_10.app_class_portfolio;

import android.support.v7.app.AppCompatActivity;

import com.example.a501_10.app_class_portfolio.util.Util;

/**
 * Created by 501-10 on 2018-03-30.
 */

public class TestActivity extends AppCompatActivity {
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    setContentView(R.layout.activity_test);
        Util.getNowDateTime();
    }
}
