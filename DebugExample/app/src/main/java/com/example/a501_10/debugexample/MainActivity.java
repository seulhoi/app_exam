package com.example.a501_10.debugexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int a = 10;
        int b = 20;
        int c = a + b;

        TextView textview  = (TextView)findViewById(R.id.textview);
        textview.setText("결과값 :" + c);
        Log.d("keyword","출력내용");
    }
}
