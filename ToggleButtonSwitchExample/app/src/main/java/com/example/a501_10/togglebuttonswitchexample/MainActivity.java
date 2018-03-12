package com.example.a501_10.togglebuttonswitchexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton_main;
    Switch switch_main, switch_main2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2.스위치 객체생성
        switch_main = (Switch)findViewById(R.id.switch_main);
        switch_main2 = (Switch)findViewById(R.id.switch_main2);


        //2. 컴포넌트의 객체 만들기
        toggleButton_main = (ToggleButton)findViewById(R.id.toggleButton_main);
        //3,4,5 리스너의 객체를 생성하여 바로 리스너에 등록함
        toggleButton_main.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                     if(b){
                         toggleButton_main.setTextOn("Turn on");
                         Toast.makeText(MainActivity.this,
                                 "버튼이 눌림",Toast.LENGTH_SHORT);
                     }else{
                         toggleButton_main.setTextOff("Turn off");
                         Toast.makeText(MainActivity.this,
                                 "버튼이 안눌림",Toast.LENGTH_SHORT);
                     }
                    }
                }
        );

        //4,5 스위치 리스너 합치기
        switch_main.setOnCheckedChangeListener(new switchListener());
        switch_main2.setOnCheckedChangeListener(new switchListener());
    }

    //3.스위치 리스너의 클래스만들기
    class switchListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            switch (compoundButton.getId()){
                case R.id.switch_main:
                    if(b){
                        Toast.makeText(MainActivity.this,
                                "111활성화 됨",Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(MainActivity.this,
                                "111비활성화 됨",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.switch_main2:
                    if(b){
                        Toast.makeText(MainActivity.this,
                                "222활성화 됨",Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(MainActivity.this,
                                "222비활성화 됨",Toast.LENGTH_SHORT).show();
                    }
                     break;
            }

        }
    }


}
