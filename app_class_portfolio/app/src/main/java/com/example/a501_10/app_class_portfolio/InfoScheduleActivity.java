package com.example.a501_10.app_class_portfolio;

import android.content.Intent;
import android.graphics.RectF;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;
import com.example.a501_10.app_class_portfolio.datalist.ScheduleList;
import com.example.a501_10.app_class_portfolio.datalist.TripList;
import com.example.a501_10.app_class_portfolio.db.Schedule;
import com.example.a501_10.app_class_portfolio.db.Trip;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by 501-10 on 2018-04-05.
 */

    public class InfoScheduleActivity extends AppCompatActivity
        implements WeekView.EventClickListener {

    Toolbar toolbar_infoSchedule;
    WeekView weekView;
    int trip_index;
    ArrayList<Trip> arrayList_trip;
    ArrayList<Schedule> arrayList_schedule;
    TextView textView_infoSche_title,textView_infoSche_day,
            textView_infoSche_member,textView_infoSche_money;
    boolean bSetSchedule = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_schedule);
        setToolbar();

        setData();

        setComponents();

        weekView = (WeekView)findViewById(R.id.weekView);

        Trip print_trip = arrayList_trip.get(trip_index);

        weekView.goToDate(getCalendarDate(
                print_trip.getStart_day().getYear(),
                print_trip.getStart_day().getMonth(),
                print_trip.getStart_day().getDate()));
        weekView.goToHour(9);

        weekView.setOnEventClickListener(this);
        MonthLoader.MonthChangeListener monthChangeListener = new MonthLoader.MonthChangeListener() {
            @Override
            public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
                return setWeekViewEvent(bSetSchedule,
                        trip_index,
                        arrayList_schedule);
            }
        };

        weekView.setMonthChangeListener(monthChangeListener);
    }

    private void setComponents(){
        textView_infoSche_title = (TextView)findViewById(R.id.textView_infoSche_title);
        textView_infoSche_day = (TextView)findViewById(R.id.textView_infoSche_day);
        textView_infoSche_member = (TextView)findViewById(R.id.textView_infoSche_member);
        textView_infoSche_money = (TextView)findViewById(R.id.textView_infoSche_money);

        Trip target = arrayList_trip.get(trip_index);

        textView_infoSche_title.setText(target.getTitle());
        String start_day = target.getStart_day().getYear()+ "/" +
                           target.getStart_day().getMonth()+ "/" +
                           target.getStart_day().getDate();
        String end_day= target.getEnd_day().getYear() + "/" +
                        target.getEnd_day().getMonth() + "/" +
                        target.getEnd_day().getDate();
        textView_infoSche_day.setText("일자 : " + start_day + " ~ " + end_day);
        textView_infoSche_member.setText("인원 : "+target.getNumber_of_member().toString()+" 명");
        textView_infoSche_money.setText("비용 : "+ target.getTotal_money().toString()+ " 원");



    }

    private void setData(){
        Intent intent = getIntent();
         trip_index =  intent.getIntExtra("SELECTED_TRIP",-1);

         arrayList_trip = TripList.getInstance();
         arrayList_schedule = ScheduleList.getInstance();
    }

    public  void onEventClick(WeekViewEvent event, RectF eventRect){}

    private void setToolbar(){
        toolbar_infoSchedule = (Toolbar)findViewById(R.id.toolbar_infoSchedule);
        toolbar_infoSchedule.setTitle("");
        toolbar_infoSchedule.setNavigationIcon(R.mipmap.ic_chevron_left_black_24dp);
        setSupportActionBar(toolbar_infoSchedule);
    }

    public boolean onSupportNavigateUp(){
        //to-do
        onBackPressed();
        return true;
    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_goto_add_schedule, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case  R.id.tool_item_goto_add_schedule:
                Intent intent = new Intent(InfoScheduleActivity.this,
                        AddScheduleActivity.class);
                intent.putExtra("SELECTED_TRIP",trip_index);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private Calendar getCalendarDate(int year, int month, int date) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DATE, date);

        return cal;
    }

    private List<WeekViewEvent> setWeekViewEvent(boolean bSetSchedule,
                                                 int trip_index, ArrayList<Schedule> arrayList_schedule) {
        Calendar startTime;
        Calendar endTime;
        Date visit_time;
        Date elapse_time;
        int[] color_arr = {
                R.color.colorSchedule1,
                R.color.colorSchedule2,
                R.color.colorSchedule3,
                R.color.colorSchedule4,
                R.color.colorSchedule5,
                R.color.colorSchedule6,
                R.color.colorSchedule7,
                R.color.colorSchedule8
        };

        ArrayList<WeekViewEvent> events = new ArrayList<WeekViewEvent>();
        if(!bSetSchedule) {


            ArrayList<Schedule> schedules = new ArrayList<Schedule>();
            for(int i = 0; i < arrayList_schedule.size(); i++) {

                if(arrayList_schedule.get(i).getTrip_id() == trip_index) {
                    schedules.add(arrayList_schedule.get(i));

                }
            }

            for(int k = 0; k < schedules.size(); k++) {
                visit_time = schedules.get(k).getVisit_time();
                elapse_time = schedules.get(k).getElapse_time();

                startTime = Calendar.getInstance();
                startTime.set(Calendar.DAY_OF_MONTH, visit_time.getDate());
                startTime.set(Calendar.HOUR_OF_DAY, visit_time.getHours());
                startTime.set(Calendar.MINUTE, visit_time.getMinutes());
                startTime.set(Calendar.MONTH, visit_time.getMonth()-1);
                startTime.set(Calendar.YEAR, visit_time.getYear());


                endTime = (Calendar) startTime.clone();
                endTime.set(Calendar.DAY_OF_MONTH, elapse_time.getDate());
                endTime.set(Calendar.HOUR_OF_DAY, elapse_time.getHours());
                endTime.set(Calendar.MINUTE, elapse_time.getMinutes());
                endTime.set(Calendar.MONTH, elapse_time.getMonth()-1);
                endTime.set(Calendar.YEAR, elapse_time.getYear());

                WeekViewEvent event = new WeekViewEvent(k, schedules.get(k).getPlace_name(),
                        startTime, endTime);



                event.setColor(getResources().getColor(color_arr[(k % color_arr.length)]));
                events.add(event);

            }
            this.bSetSchedule = true;

        }


        return events;
    }

}
