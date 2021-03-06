package com.example.a501_10.app_class_portfolio;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.a501_10.app_class_portfolio.datalist.PlaceList;
import com.example.a501_10.app_class_portfolio.datalist.ScheduleList;
import com.example.a501_10.app_class_portfolio.datalist.TripList;
import com.example.a501_10.app_class_portfolio.db.DaoSession;
import com.example.a501_10.app_class_portfolio.db.Place;
import com.example.a501_10.app_class_portfolio.db.PortfolioQuery;
import com.example.a501_10.app_class_portfolio.db.Schedule;
import com.example.a501_10.app_class_portfolio.db.Trip;
import com.example.a501_10.app_class_portfolio.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 501-10 on 2018-04-05.
 */

public class AddScheduleActivity extends AppCompatActivity {

    Toolbar toolbar_addSche;
    EditText editText_addSche_visitTime,editText_addSche_inTime,editText_addSche_money,
             editText_addSche_visitDay;
    TimePickerListener timePickerListener;
    ImageButton btn_addSche_minus, btn_addSche_plus;

    DaoSession daoSession;
    ArrayList<Place> arrayList_place;
    ArrayList<Schedule> arrayList_schedule;
    ArrayList<Trip> arrayList_trip;
    TextView textView_addSche_name;
    ImageView imageView_addSche_img;
    TextView textView_addSche_money;

    int inTime = 30;
    int visit_hour, visit_min;
    int place_index;
    int trip_index;

    int visit_year,visit_month,visit_day;
    int elapse_hour,elapse_min,elapse_year, elapse_month,elapse_day;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);

    setToolbar();
    setData();
    setComponents();

    }

    private void setComponents(){
        editText_addSche_visitTime = (EditText)findViewById(R.id.editText_addSche_visitTime);
        editText_addSche_inTime = (EditText)findViewById(R.id.editText_addSche_inTime);
        editText_addSche_money = (EditText)findViewById(R.id.editText_addSche_money);
        btn_addSche_plus = (ImageButton)findViewById(R.id.btn_addSche_plus);
        btn_addSche_minus = (ImageButton)findViewById(R.id.btn_addSche_minus);


//        여행지명 가져오기
        textView_addSche_name = (TextView)findViewById(R.id.textView_addSche_name);
        textView_addSche_name.setText(Util.getPlaceTitle(AddScheduleActivity.this));

// **여행사진 가져오기
        imageView_addSche_img = (ImageView)findViewById(R.id.imageView_addSche_img);
//        관광지 정보가져오기
        for(int i =0; i< arrayList_place.size(); i++){
            if (arrayList_place.get(i).getName().equals(Util.getPlaceTitle(
                    AddScheduleActivity.this))){
//                이미지이름으로 파일찾기
                    String name = arrayList_place.get(i).getImg_name();
                    int img_id = getResources().getIdentifier(
                            "@drawable/" + name,
                            "drawble",
                            this.getPackageName());
                    //이미지를 이미지뷰에 전달 **
                    imageView_addSche_img.setImageResource(img_id);
            }
        }

        editText_addSche_visitDay = (EditText)findViewById(R.id.editText_addSche_visitDay);
        editText_addSche_visitDay.setInputType(InputType.TYPE_NULL);
        editText_addSche_visitDay.setFocusable(false);
        editText_addSche_visitDay.setOnClickListener(new AddSchedListener());


        //editText에 text 띄우기
        editText_addSche_inTime.setText("30 분");

        //리스너 객체 등록
        editText_addSche_visitTime.setOnClickListener(new AddSchedListener());
        btn_addSche_minus.setOnClickListener(new AddSchedListener());
        btn_addSche_plus.setOnClickListener(new AddSchedListener());

        //키보드 없애주는 옵션
        editText_addSche_visitTime.setInputType(InputType.TYPE_NULL);
        editText_addSche_visitTime.setFocusable(false);
        editText_addSche_inTime.setInputType(InputType.TYPE_NULL);
        editText_addSche_inTime.setFocusable(false);

       // textView_addSche_name.setText(Util.getPlaceTitle());
        for(int i =0; i<arrayList_place.size(); i++){
            if(arrayList_place.get(i).getId()
                    == Util.getPlaceIndex(AddScheduleActivity.this)){
                textView_addSche_name.setText(
                        arrayList_place.get(i).getName());
            }
        }


    }



    private Date setElapseDate(int inTime, int aHour, int aMin){
        int total = aMin + inTime;
        int min = total % 60;
        int hour = aHour + (total / 60);

        Date result = new Date();
        result.setHours(hour);
        result.setMinutes(min);

        return result;
    }



    class AddSchedListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){

                case R.id.editText_addSche_visitDay:
                    //데이트피커 리스너 생성
                    DatePickerListener datePickerListener = new DatePickerListener();
//
                    Calendar min = Calendar.getInstance();
                    Calendar max = Calendar.getInstance();
//
                    Trip trip_info = arrayList_trip.get(trip_index);
//
//                    //여행일정을 가져옴
                    min.set(Calendar.YEAR, trip_info.getStart_day().getYear());
                    min.set(Calendar.MONTH, trip_info.getStart_day().getMonth()-1);
                    min.set(Calendar.DAY_OF_MONTH, trip_info.getStart_day().getDate());

                    max.set(Calendar.YEAR, trip_info.getEnd_day().getYear());
                    max.set(Calendar.MONTH, trip_info.getEnd_day().getMonth()-1);
                    max.set(Calendar.DAY_OF_MONTH, trip_info.getEnd_day().getDate());

                    DatePickerDialog datePickerDialog =
                           new DatePickerDialog(AddScheduleActivity.this,
                            datePickerListener,
                            2018,4,26);

                            datePickerDialog.getDatePicker().setMinDate(min.getTime().getTime());
                            datePickerDialog.getDatePicker().setMaxDate(max.getTime().getTime());
                            datePickerDialog.show();

                    break;

                case R.id.editText_addSche_visitTime :
                    //타임피커 리스너 생성
                    timePickerListener = new TimePickerListener();

                    new TimePickerDialog(AddScheduleActivity.this, timePickerListener,
                            11,11,true).show();
                    break;
                case R.id.btn_addSche_minus:
                    inTime -= 30;
                    if(inTime == 0){
                        inTime = 30;
                    }
                   // editText_addSche_inTime.setText(inTime + " 분");
                    editText_addSche_inTime.setText(convertTime(inTime));
                    break;
                case R.id.btn_addSche_plus:
                    //inTime = inTime + 30; (같은의미)
                    inTime += 30;
                 //   editText_addSche_inTime.setText(inTime + " 분");
                    editText_addSche_inTime.setText(convertTime(inTime));
                    break;
            }
        }
    }

    class DatePickerListener implements  DatePickerDialog.OnDateSetListener{

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            visit_year = i;
            visit_month = (i1+1);
            visit_day = i2;

            editText_addSche_visitDay.setText(i+"/"+(i1+1)+"/"+ i2);
        }
    }

    class TimePickerListener implements TimePickerDialog.OnTimeSetListener{

        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            visit_hour = i;
            visit_min = i1;
            editText_addSche_visitTime.setText(i + ":" + i1);
          /*  Toast.makeText(AddScheduleActivity.this, i+":"+i1,
                    Toast.LENGTH_LONG).show(); */
        }
    }

    private void setData(){
        Intent intent = getIntent();
        trip_index = intent.getIntExtra("SELECTED_TRIP",-1);
        place_index = Util.getPlaceIndex(AddScheduleActivity.this);
        arrayList_trip = TripList.getInstance();

        daoSession = ((AppController)getApplication()).getDaoSession();
        arrayList_schedule = ScheduleList.getInstance();
        arrayList_place = PlaceList.getInstance();

        Log.d("Place_index",Integer.toString(place_index));
    }

    private  void setToolbar(){
        toolbar_addSche = (Toolbar)findViewById(R.id.toolbar_addSche);
        toolbar_addSche.setTitle("");
        toolbar_addSche.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
        setSupportActionBar(toolbar_addSche);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_add_schedule, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case  R.id.toolbar_item_add_schedule:
                Date ElapseDate = setElapseDate(inTime, visit_hour,visit_min);
                elapse_hour= ElapseDate.getHours();
                elapse_min = ElapseDate.getMinutes();
                elapse_day = visit_day;
                elapse_month = visit_month;
                elapse_year = visit_year;

                PortfolioQuery.insertSchedule(daoSession, arrayList_schedule,
                        textView_addSche_name.getText().toString(),
                        new Date(elapse_year, elapse_month, elapse_day, elapse_hour, elapse_min),
                        Long.parseLong(editText_addSche_money.getText().toString()),
                        new Date(visit_year, visit_month, visit_day, visit_hour, visit_min),
                        arrayList_trip.get(trip_index).getId(),
                        arrayList_place.get(place_index).getId());


                PortfolioQuery.logSchedule("MySchedule", arrayList_schedule);

                Intent intent = new Intent(AddScheduleActivity.this,
                        InfoScheduleActivity.class);
                intent.putExtra("SELECTED_TRIP",trip_index);
                startActivity(intent);
                finish();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class MyListener implements View.OnFocusChangeListener{

        @Override
        public void onFocusChange(View view, boolean b) {

        }
    }

    private  String convertTime2(int aMin){
        String result = "";
        int total = aMin;
        int part = 0;
        int hour;

        while(total > 0) {
            total -= 30;
            part ++;
        }
        hour = (part/2);

        if(hour != 0){
            result += " 30 분";
        }
        return result;
    }


    private String convertTime(int aMin){
        String result = "";

        int hour = aMin /60;
        int min = aMin % 60;

        if(hour == 0){
            result = min + "분";
        }else {
            if(min == 0){
                result = hour + " 시간 ";
                }else{
                result = hour + " 시간 " + min + " 분";
            }
        }
        return result;
    }

}
