package com.example.a501_10.activityexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1.객체만들기
    Button btn_first, btn_second, btn_movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2.객체생성
        btn_first = (Button)findViewById(R.id.btn_first);
        btn_second =(Button)findViewById(R.id.btn_second);
        btn_movie = (Button)findViewById(R.id.btn_movie);

        //4.리스너등록
        CallListener callListener = new CallListener();
        btn_first.setOnClickListener(callListener);
        btn_second.setOnClickListener(callListener);
        btn_movie.setOnClickListener(callListener);

    }

//    3.리스너 객체 만들기
    class CallListener implements View.OnClickListener{
        //Intent: 메인과 first를 연결해줄 객체
        //getApplicationContext :메인액티비티를 의미(출발지),
        //FirstActivity: first액티비티를 불러달란 의미(목적지)
    @Override
    public void onClick(View view) {
        Intent intent = null;
     switch (view.getId()){
         case R.id.btn_first:
             intent = new Intent(getApplicationContext(),
                     FirstActivity.class);
             break;
         case R.id.btn_second:
             intent = new Intent(getApplicationContext(),
                     SecondActivity.class);
             break;
         case R.id.btn_movie:
             intent = new Intent(getApplicationContext(),
                     movieActivity.class);
     }
        //startActivity: 실제 화면을 전환시켜줄 명령어
        startActivity(intent);

    }
}

}
