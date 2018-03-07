package com.example.a501_10.listview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by 501-10 on 2018-03-07.
 */

public class BookCompAtivity extends AppCompatActivity {
        Button btn_call, btn_web, btn_map, btn_con;

        @Override
    protected  void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_book_comp);


            btn_call = (Button)findViewById(R.id.btn_call);
            btn_web = (Button)findViewById(R.id.btn_web);
            btn_map = (Button)findViewById(R.id.btn_map);
            btn_con = (Button)findViewById(R.id.btn_con);

            BtnListener btnListener = new BtnListener();

            btn_call.setOnClickListener(btnListener);
            btn_web.setOnClickListener(btnListener);
            btn_map.setOnClickListener(btnListener);
            btn_con.setOnClickListener(btnListener);

        }

        class BtnListener implements View.OnClickListener{

            @Override
            public void onClick(View view) {

                switch(view.getId()){
                    case R.id.btn_call:
                        Intent intent1 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("tel:012-345-4567"));
                        startActivity(intent1);
                        break;
                    case R.id.btn_web:
                        Intent intent2 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.naver.com"));
                        startActivity(intent2);
                        break;
                    case R.id.btn_map:
                        Intent intent3 = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:36.6282990,127.4583250"));
                        startActivity(intent3);
                        break;
                    case R.id.btn_con:
                        Intent intent4 = new Intent(BookCompAtivity.this,
                                MainActivity.class);
                }
            }
        }

}
