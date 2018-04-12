package com.example.a501_10.app_class_portfolio.datalist;

import com.example.a501_10.app_class_portfolio.db.Place;
import com.example.a501_10.app_class_portfolio.db.Trip;

import java.util.ArrayList;

/**
 * Created by 501-10 on 2018-04-12.
 */

public class PlaceList {
    private static ArrayList<Place> placeList =
            new ArrayList<Place>();
    private PlaceList(){}
    public static synchronized  ArrayList<Place> getInstance(){
        return placeList;
    }
}
