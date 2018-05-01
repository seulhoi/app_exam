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

        setPlaceData();

        PortfolioQuery.setInitAllData(daoSession, arrayList_place,
                                    arrayList_schedule, arrayList_trip);



        PortfolioQuery.logTrip("myLogs", arrayList_trip);
        PortfolioQuery.logPlace("myLogs", arrayList_place);
        PortfolioQuery.logSchedule("myLogs", arrayList_schedule);


//        try{
//            Thread.sleep(5000);
//            Toast.makeText(this,"5초가 지났습니다.", Toast.LENGTH_LONG).show();
//        }catch(Exception e){;}


        Intent intent =  new Intent(SplashActivity.this,
                MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void setPlaceData(){
        if(arrayList_place.isEmpty()){
            PortfolioQuery.insertPlace(daoSession,arrayList_place,
                    "악휘봉","악휘봉은 괴산군 연풍면과 칠성면 경계에 위치한 해발 845m의" +
                            " 산으로 백두대간의 본 줄기에서 한발짝 벗어난 절경의 산이다. ","place1");
            PortfolioQuery.insertPlace(daoSession,arrayList_place,
                    "작은 용굴 분수대","문의면 구룡리 마을 뒤에 있는 석회암 동굴 유적으로 이 굴에서 용이 승천하였다는" +
                            " 전설이 있어 용굴이라 전해지며 석회암 지대에 발달된 수평동굴","place2");
            PortfolioQuery.insertPlace(daoSession,arrayList_place,
                    "문의문화재단지","문의문화재단지(文義文化材團地)는 인류문명의 발달과 급속한 산업화에 따라 사라져 가고 있는 " +
                            "우리의 고유 전통문화를 재현하여 조상들의 삶과 얼을 되살리고 배우기 위한 역사의 교육장","place3");
            PortfolioQuery.insertPlace(daoSession,arrayList_place,
                    "상수허브랜드","상수허브랜드는 허브에 관한 모든 것을 보고 느끼고 맛볼 수 있는 국내 최대의 허브농장이다. ","place4");

            PortfolioQuery.insertPlace(daoSession,arrayList_place,
                    "의암 손병희 유허지","충청북도 괴산군 사리면 사담리 보광사의 봉학사터에 있던 조선시대 불상으로 높이는 95cm이며," +
                            " 충청북도 유형문화재 제30호로 지정되어 있다","place5");
            PortfolioQuery.insertPlace(daoSession,arrayList_place,
                    "대청호","끝없이 이어지는 맑은 물과 호수 위에 섬처럼 떠있는 야산 그리고 새벽이면 물안개가 자욱이 떠오르고 낮에는 " +
                            "쪽빛 하늘과 흰구름이 한폭의 수채화를 연상시킨다","place6");

        }
    }
}
