package com.example.a501_10.listview;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.GregorianCalendar;

/**
 * Created by 501-10 on 2018-03-05.
 */

public class BookActivity extends AppCompatActivity {

    Button btn_time, btn_date;
    int year,month,day,hour,min;
    DatePickerListener datePickerListener;
    TimePickerListener timePickerListener;
    TextView textview_book_date,textview_book_time;


    //시크바 추가 컴포넌트변수
    SeekBar seekbar_num;
    TextView textview_seats;
    Button btn_reset;

    //예매완료 화면으로 이동변수
    Button btn_gocomp, btn_cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        //현재 시간과 날짜를 얻음
        GregorianCalendar cal = new GregorianCalendar();
        year = cal.get(cal.YEAR);
        month = cal.get(cal.MONTH);
        day = cal.get(cal.DAY_OF_MONTH);
        hour = cal.get(cal.HOUR);
        min = cal.get(cal.MINUTE);

        //2.컴포넌트 객체만들기
        btn_time = (Button)findViewById(R.id.btn_time);
        btn_date = (Button)findViewById(R.id.btn_date);
        textview_book_date = (TextView)findViewById(R.id.textview_book_date);
        textview_book_time = (TextView)findViewById(R.id.textview_book_time);


        seekbar_num = (SeekBar)findViewById(R.id.seekbar_num);
        textview_seats =(TextView)findViewById(R.id.textview_seats);
        btn_reset =(Button)findViewById(R.id.btn_reset);

        //예매하기 버튼이동
        btn_gocomp = (Button)findViewById(R.id.btn_gocomp);
        btn_cancle = (Button)findViewById(R.id.btn_cancle);


        //4.리스너 객체만들기
        BtnListener btnListener = new BtnListener();
        timePickerListener = new TimePickerListener();
        datePickerListener = new DatePickerListener();

        ResetBtnListener resetBtnListener = new ResetBtnListener();
        SeekbarNumListener seekbarNumListener = new SeekbarNumListener();

        BookcompListiner bookcompListiner = new BookcompListiner();

        //5.리스너 객체를 컴포넌트에 등록하기
        btn_date.setOnClickListener(btnListener);
        btn_time.setOnClickListener(btnListener);
        seekbar_num.setOnSeekBarChangeListener(seekbarNumListener);
        btn_reset.setOnClickListener(resetBtnListener);

        btn_gocomp.setOnClickListener(bookcompListiner);
        btn_cancle.setOnClickListener(bookcompListiner);

    }
    //3.버튼 리스너 클래스 만들기 (implements:수행하다,적용하다)

         /*버튼리스너 먼저 생성 후 그 안에 TimePicker,DatePicker 클래스를
             사용해야 하기 때문에 아래 리스너클래스 생성  */
    //TimePickerDialog true:24시표기, false:12시표기
    class BtnListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_date :
                    //6. 리스너 객체를 활용하여 다이얼로그 호출
                    new DatePickerDialog(BookActivity.this, datePickerListener,
                            2018,3,6).show();
                    break;
                case R.id.btn_time:
                    new TimePickerDialog(BookActivity.this, timePickerListener ,
                            11,43,false).show();

                    break;
            }
        }
    }
    //DatePicker 리스너 클래스생성
    class DatePickerListener implements DatePickerDialog.OnDateSetListener{

        //int i, int i1, int i2 [년,월(0부터시작 그래서 1월부터 하려면 +1 해줌),일]
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            textview_book_date.setText("예매날짜 :"+i+"년 "+(i1+1)+"월 "+i2+"일");

        }
    }
    //TimePicker 리스너 클래스생성
    class TimePickerListener implements TimePickerDialog.OnTimeSetListener{

        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
        textview_book_time.setText("예매시간 :" +i+"시 "+i1+"분");
        }
    }

    //시크바 클래스 생성
    class SeekbarNumListener implements SeekBar.OnSeekBarChangeListener{
        //시크바를 움직일때 호출
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        textview_seats.setText("현재 좌석: "+(i+1)+" 석");
        }
        //시크바를 터치할 때 호출
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}
        //시크바에서 손을 뗄 때 호출
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {}
    }

    //시크바 초기화버튼 클래스생성

    class ResetBtnListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            seekbar_num.setProgress(0);
        }
    }


    //예매완료 화면 이동 리스너 클래스생성
    class BookcompListiner implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_cancle:
                    finish();
                    break;
                case R.id.btn_gocomp:
                    Intent intent1 = new Intent(BookActivity.this,
                            BookCompAtivity.class);
                    startActivity(intent1);
                     break;
            }
        }
    }

}
