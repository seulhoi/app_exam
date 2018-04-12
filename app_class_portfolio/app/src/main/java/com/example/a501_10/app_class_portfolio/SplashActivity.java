package com.example.a501_10.app_class_portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.a501_10.app_class_portfolio.datalist.PlaceList;
import com.example.a501_10.app_class_portfolio.datalist.ScheduleList;
import com.example.a501_10.app_class_portfolio.datalist.TripList;
import com.example.a501_10.app_class_portfolio.db.DaoSession;
import com.example.a501_10.app_class_portfolio.db.Place;
import com.example.a501_10.app_class_portfolio.db.PortfolioQuery;
import com.example.a501_10.app_class_portfolio.db.Schedule;
import com.example.a501_10.app_class_portfolio.db.Trip;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 501-10 on 2018-03-30.
 */

public class SplashActivity extends AppCompatActivity {

    DaoSession daoSession;

    ArrayList<Place> arrayList_place;
    ArrayList<Schedule> arrayList_schedule;
    ArrayList<Trip> arrayList_trip;

    @Override
    protected void onCreate (@Nullable  Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //앱을 동작하기 위한 준비를 함

        daoSession = ((AppController)getApplication()).getDaoSession();

        arrayList_place = PlaceList.getInstance();
        arrayList_schedule = ScheduleList.getInstance();
        arrayList_trip = TripList.getInstance();

        PortfolioQuery.setInitAllData(daoSession, arrayList_place,
                                    arrayList_schedule, arrayList_trip);


//        try{
//            Thread.sleep(3000);
//            Toast.makeText(this,"3초가 지났습니다.", Toast.LENGTH_LONG).show();
//        }catch(Exception e){;}

        Intent intent =  new Intent(SplashActivity.this,
                AddTripActivity.class);
        startActivity(intent);
        finish();
    }
}
