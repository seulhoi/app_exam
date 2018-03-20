package com.example.a501_10.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String temp = "";

        TextView textView_main = (TextView)findViewById(R.id.textview_main);

        //json파일을 읽어와서 문자열로 저장
        String json_str = "[{'name':'홍길동','book':'홍길동전', 'age':20}," +
                          "{'name':'이순신','book':'난중일기','age':50}]" ;
        try {
            JSONArray jsonArray = new JSONArray(json_str);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String book = jsonObject.getString("book");
                int age = jsonObject.getInt("age");
                temp += name + " " + book + " " + age +"\n";

                }
               textView_main.setText(temp);
            } catch(Exception e){}



    }
}
