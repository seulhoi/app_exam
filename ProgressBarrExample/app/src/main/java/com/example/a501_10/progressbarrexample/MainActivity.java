package com.example.a501_10.progressbarrexample;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import static android.view.View.VISIBLE;


// **ProgressBar: 작업의 진행 정도를 시각적으로 보여주는 컴포넌트

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar_circle, progressBar_bar,progressBar_3sec;
    Button btn_minus,btn_plus,btn_3sec;
    Switch swtich_onoff;
    int number;

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

    class MyThread2 extends Thread{
        int command;
        MyThread2(int aCommand){
            command = aCommand;
        }
        public void run() {
            switch(command){
                case 1:
                        try{
                    Thread.sleep(5000);
                        }catch (Exception e){}
                        handler.sendEmptyMessage(1);
                        break;
                case 2:
                    while (true){
                        try{
                            Thread.sleep(1000);
                            handler.sendEmptyMessage(2);
                        }catch (Exception e){}
                    }
                case 3:
                    while (true){
                        try {
                            Thread.sleep(1000);
                            number++;
                            Log.d("NUMBER", Integer.toString(number));
                        }catch(Exception e){}
                    }
            }
        }
    }


    //*2.핸들러 만들기(UI 관련 처리를 위해 스레드에서 메인스레드로 요청하기 위함)
    Handler handler = new Handler(){
        //실행단계5 - 스레드에게 일이 종료되었음으로 보고받음
        public void handleMessage(Message msg){
            switch (msg.what){
                case 0 :
                    //실행단계 6 - 메인스레드에게 일의 결과와 메인스레드만 할 수 있는 일을 알려줌
                    progressBar_3sec.setVisibility(View.INVISIBLE);
                    break;

                    /*
                    * 5초 후에 토스트 메시지 띄우기*/
                case 1:
                    Toast.makeText(MainActivity.this,
                            "5초 후에 나타나는 메시지",Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    String text = btn_3sec.getText().toString();
                    if(text.equals("3sec")){
                        btn_3sec.setText("3sec!!!!!");
                    }else{
                        btn_3sec.setText("3sec");
                    } break;

            }

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
                    MyThread2 myThread1 = new MyThread2(1);
                    myThread1.setDaemon(true);
                    myThread1.start();

                    MyThread2 myThread2 = new MyThread2(2);
                    myThread2.setDaemon(true);
                    myThread2.start();

                    MyThread2 myThread3 = new MyThread2(3);
                    myThread3.setDaemon(true);
                    myThread3.start();


                //   MyThread myThread = new MyThread();
                //    myThread.setDaemon(true);
                    //실행단계2 - 스레드 객체에게 일을 시킴
                //    myThread.start();
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
