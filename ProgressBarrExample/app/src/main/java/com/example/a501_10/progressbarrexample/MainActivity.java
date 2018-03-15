package com.example.a501_10.progressbarrexample;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;

import static android.view.View.VISIBLE;


// **ProgressBar: 작업의 진행 정도를 시각적으로 보여주는 컴포넌트

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar_circle, progressBar_bar,progressBar_3sec;
    Button btn_minus,btn_plus,btn_3sec;
    Switch swtich_onoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar_circle =(ProgressBar)findViewById(R.id.progressBar_circle);
        swtich_onoff = (Switch)findViewById(R.id.swtich_onoff);
        progressBar_bar =(ProgressBar)findViewById(R.id.progressBar_bar);
        btn_minus =(Button)findViewById(R.id.btn_minus);
        btn_plus =(Button)findViewById(R.id.btn_plus);

        btn_3sec =(Button)findViewById(R.id.btn_3sec);
        progressBar_3sec = (ProgressBar)findViewById(R.id.progressBar_3sec);

     /*
        progressBar_bar.setMax(200);
        int num = progressBar_bar.getMax();
        progressBar_bar.setProgress(100);
        progressBar_bar.setSecondaryProgress(150);
     */
        //4.리스너객체생성
        SwitchListener switchListener = new SwitchListener();

        //5.리스너의 객체를 컴포넌트에 등록
        swtich_onoff.setOnCheckedChangeListener(switchListener);
        btn_3sec.setOnClickListener(new ButtonListener());
        btn_plus.setOnClickListener(new ButtonListener());
        btn_minus.setOnClickListener(new ButtonListener());
    }
    //스레드 만들기
    //*1. 스레드의 클래스를 만든다.
    class MyThread extends Thread{
        public void run(){
            //실행단계3 - 스레드가 실제로 일을 함
            try{
                Thread.sleep(3000);
            }catch (Exception e){}

            //실행단계4 - 핸들러에게 일을 마쳤음을 보고
            handler.sendEmptyMessage(0);
        }
    }



    //*2.핸들러 만들기(UI 관련 처리를 위해 스레드에서 메인스레드로 요청하기 위함)
    Handler handler = new Handler(){
        public void handleMessage(Message msg){
            progressBar_3sec.setVisibility(View.INVISIBLE);
        }
    };



    //3.리스너의 클래스만들기
    class ButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_3sec :
                    progressBar_3sec.setVisibility(View.VISIBLE);
                    //실행단계1 -스레드 객체가 만들어짐
                    MyThread myThread = new MyThread();
                    myThread.setDaemon(true);
                    //실행단계2 - 스레드 객체에게 일을 시킴
                    myThread.start();
                    break;
                case R.id.btn_minus:
                    //incrementProgressBy(얼마) 현재값 기준으로 얼만큼 증가,감소시켜줌
                    progressBar_bar.incrementProgressBy(-10);
                    break;
                case R.id.btn_plus:
                    progressBar_bar.incrementProgressBy(10);
                    break;
            }
        }
    }
    class SwitchListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b){
                //컴포넌트를 보여줌
                progressBar_circle.setVisibility(View.VISIBLE);
            }else {
                //컴포넌트를 안보여줌
                progressBar_circle.setVisibility(View.INVISIBLE);
            }
        }
    }
}
