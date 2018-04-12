package com.example.a501_10.app_class_portfolio.datalist;

import com.example.a501_10.app_class_portfolio.db.Place;
import com.example.a501_10.app_class_portfolio.db.Schedule;

import java.util.ArrayList;

/**
 * Created by 501-10 on 2018-04-12.
 */

public class ScheduleList {
    private static ArrayList<Schedule> ScheduleList =
            new ArrayList<Schedule>();
    private ScheduleList(){}
    public static synchronized  ArrayList<Schedule> getInstance(){
        return ScheduleList;
    }
}
