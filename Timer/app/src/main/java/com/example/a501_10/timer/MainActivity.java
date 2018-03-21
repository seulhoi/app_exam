package com.example.a501_10.timer;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_min, editText_sec;
    TextView textView_time;
    Button btn_start, btn_stop;
    int min,sec;
    CookTimerAsyncTask timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setComponents();
    }

    public String printMin(int min){
        if(min < 10){
            return "0"+Integer.toString(min);
        }
        return Integer.toString(min);
    }

    public String printSec(int sec){
        if(sec < 10){
            return "0"+Integer.toString(sec);
        }
        return Integer.toString(sec);
    }

    public void setComponents(){
        editText_min = (EditText)findViewById(R.id.editText_min);
        editText_sec = (EditText)findViewById(R.id.editText_sec);
        textView_time = (TextView)findViewById(R.id.textView_time);
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_stop = (Button)findViewById(R.id.btn_stop);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText_sec.getText().toString() != ""
                        && editText_min.getText().toString() != ""){
                    min = Integer.parseInt(editText_min.getText().toString());
                    sec = Integer.parseInt(editText_sec.getText().toString());
                }
                timer = new CookTimerAsyncTask();
                timer.execute();
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel(false);
            }
        });

    }




    public class CookTimerAsyncTask extends AsyncTask<Void ,Void, Void> {
        protected  void onPreExecute() {
            textView_time.setText(min+" : "+sec);
        }

    protected Void doInBackground(Void... arg){
            while (isCancelled() == false){
                sec--;
                if(sec < 0) {
                    min--;
                    sec = 59;
                    publishProgress();
                }
                    if(sec == 0 && min == 0){
                        break;
                    }
                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){
                        Log.d("CookTimer","doInBackground()");
                    }
                }
                return null;
            }

            protected void onProgressUpdate(Void... arg){
                textView_time.setText(min+":"+sec);
        }
        protected void onPostExecute(Void result){
                textView_time.setText("00:00");
                editText_sec.setText(0);
                editText_min.setText(0);

            Toast.makeText(getApplicationContext(),
                    "타이머가 완료되었습니다.",
                    Toast.LENGTH_LONG).show();
        }

        protected void onCancelled(){
            textView_time.setText("00:00");
            editText_sec.setText(0);
            editText_min.setText(0);

            Toast.makeText(getApplicationContext(),
                    "타이머가 취소되었습니다.",
                    Toast.LENGTH_LONG).show();
        }
    }
 }


