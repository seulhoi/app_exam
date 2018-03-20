package com.example.a501_10.asynctaskexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_stop;
    ProgressBar progressBar_main;
    TextView textView_main;
    int count_value;
    MyAsyncTask myAsyncTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setConponents();
    }

    //AsycTask  객체를 생성하기 위한 클래스
    //AsyncTask <A,B,C>
    //A : doInbackground(자료형...) 함수의 매개변수 자료형태(...제외)
    //B : onProgressUpdate(자료형...) 함수의 매개변수 자료형태(...제외)
    //C : onPostExecute(자료형...) 함수의 매개변수 자료형태(...제외)


    class  MyAsyncTask extends AsyncTask<Void, Void, Void>{
        //작업 시작 전에 계산을 위한 초기화, 컴포넌트 값 초기화(프로그래스바 표시)를 처리하는 함수
        protected  void onPostExcute(){  count_value = 0;}

        //작업을 진행하는 함수, publishProgress() 함수를 호출하여 진행사항을 앱 화면에 표시함
        protected  Void doInBackground(Void... arg){
            //isCancelled() 작업이 취소 되었는지 확인하는 함수
            while(isCancelled() == false){
                count_value++;

                if(count_value<=1000){
                    //keep count
                    publishProgress();
                }else{
                    break;
                    //1초 기다리는 함수 1sec =1000 milli sec
                }try{
                    Thread.sleep(1000);
                }catch(Exception e){}
            }
         return null;
     }
     //작업 진행 사항을 표시하기 위한 함수, publishProgress()함수를 호출하면 동작
          protected  void onProgressUpdate(Void ... arg){
            progressBar_main.setVisibility(View.INVISIBLE);
            textView_main.setText(Integer.toString(count_value));
        }

        //작업 진행이 끝나면 호출되는 함수, doInBackground()함수의 리턴 값을 매개 변수로 받는다.
        protected  void onPostExecute(Void result){
            progressBar_main.setVisibility(View.INVISIBLE);
            count_value = 0;
        }

        //작업 진행 중에 작업 취소할 때 호출되는 함수
            protected  void onCancelled(){
                progressBar_main.setVisibility(View.INVISIBLE);
                textView_main.setText("사용자에 의해 종료되었습니다.");
            }
     }

    private void setConponents(){
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_stop = (Button)findViewById(R.id.btn_stop);
        textView_main = (TextView)findViewById(R.id.textView_main);
        progressBar_main = (ProgressBar)findViewById(R.id.progressBar_main);

        btn_start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(myAsyncTask == null){
                    myAsyncTask = new MyAsyncTask();
                    //AyncTask 객체가 작업을 시작함
                    myAsyncTask.execute();
                }
            }
          });

        btn_stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(myAsyncTask == null){
                    //AsyncTask 가 진행하고 있는 작업을 취소함
                    myAsyncTask.cancel(false);
                    myAsyncTask = null;
                }
            }
        });

    }

}
