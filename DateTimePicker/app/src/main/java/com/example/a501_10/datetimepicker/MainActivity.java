package com.example.a501_10.datetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    Button btn_time, btn_date;
    DatesetListener dateSetListener;
    MyButtonListener myButtonListener;
    TimeSetListener timeSetListener;
    int year,month,day,hour,min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //현재 시간과 날짜를 얻음
        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        min = calendar.get(Calendar.MINUTE);


        //2.컴포넌트의 객체만들기
        btn_time = (Button)findViewById(R.id.btn_time);
        btn_date = (Button)findViewById(R.id.btn_date);

        //4.리스너 객체 만들기(버튼, 타임피커)
        dateSetListener = new DatesetListener();
        timeSetListener = new TimeSetListener();
        myButtonListener = new MyButtonListener();
        btn_date.setOnClickListener(myButtonListener);
        btn_time.setOnClickListener(myButtonListener);
    }
    //3.리스터 만들기(버튼, 타임피커, 데이트피커)
    class MyButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_time:
                    new DatePickerDialog(MainActivity.this,
                            dateSetListener, 2018,3,5).show();
                    break;
                case R.id.btn_date:
                    new TimePickerDialog(MainActivity.this,timeSetListener,
                            4,27,false).show();
                    break;
            }
        }
    }
    class TimeSetListener implements TimePickerDialog.OnTimeSetListener{


        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            Toast.makeText(MainActivity.this,(i+1)+":"+i1,
                    Toast.LENGTH_LONG).show();
        }
    }

    class DatesetListener implements DatePickerDialog.OnDateSetListener{


        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Toast.makeText(MainActivity.this,i+"/"+i1+"/"+i2,
                    Toast.LENGTH_LONG).show();
        }
    }

}
