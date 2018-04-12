package com.example.a501_10.app_class_portfolio;

import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 501-10 on 2018-04-05.
 */

    public class InfoScheduleActivity extends AppCompatActivity
        implements WeekView.EventClickListener {

    Toolbar toolbar_infoSchedule;
    WeekView weekView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_schedule);
        setToolbar();
        weekView = (WeekView)findViewById(R.id.weekView);

        weekView.setOnEventClickListener(this);
        MonthLoader.MonthChangeListener monthChangeListener = new MonthLoader.MonthChangeListener() {
            @Override
            public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
                return new ArrayList<WeekViewEvent>();
            }
        };

        weekView.setMonthChangeListener(monthChangeListener);
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
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
