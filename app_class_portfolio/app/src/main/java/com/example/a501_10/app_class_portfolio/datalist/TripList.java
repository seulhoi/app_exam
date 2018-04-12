package com.example.a501_10.app_class_portfolio.datalist;

import com.example.a501_10.app_class_portfolio.db.Trip;

import java.util.ArrayList;

/**
 * Created by 501-10 on 2018-04-10.
 */

public class TripList {
    private static ArrayList<Trip> tripList =
            new ArrayList<Trip>();

    public static synchronized  ArrayList<Trip> getInstance(){
        return tripList;
    }

}
