package com.example.a501_10.app_class_portfolio;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.a501_10.app_class_portfolio.datalist.TripList;
import com.example.a501_10.app_class_portfolio.db.PortfolioQuery;
import com.example.a501_10.app_class_portfolio.db.Trip;

import java.util.ArrayList;

/**
 * Created by 501-10 on 2018-04-03.
 */

public class ListTripActivity extends AppCompatActivity {

    Toolbar toolbar_listTrip;
  //  ListView listView_tripList;
    ArrayList<Trip> arrayList_trip;
    TripListAdapter adapter_tripList;

    SwipeMenuListView swipeMenuListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_trip);

        setToolbar();
        setData();
        setComponents();
        setTripList();
    }
    private void setTripList(){
        adapter_tripList = new TripListAdapter(ListTripActivity.this,
                arrayList_trip,R.layout.item_trip_list);
        swipeMenuListView.setAdapter(adapter_tripList);

        swipeMenuListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(ListTripActivity.this,
                                InfoScheduleActivity.class);
                        intent.putExtra("SELECTED_TRIP",i);
                        startActivity(intent);
                    }
                }
        );

    }
    private void setData(){
        arrayList_trip = TripList.getInstance();

        PortfolioQuery.logTrip("myTrip", arrayList_trip);
    }
    private void setComponents(){
     //   listView_tripList = (ListView)findViewById(R.id.listView_tripList);
        swipeMenuListView = (SwipeMenuListView)findViewById(R.id.swipeMenuListView);

        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
               /* SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(dp2px(90));
                // set item title
                openItem.setTitle("Open");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);*/

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.mipmap.ic_remove_white_24dp);
//                deleteItem.setTitle("delete");
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };  // set creator
        swipeMenuListView.setMenuCreator(creator);

        swipeMenuListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
//                    case 0:
//                        // open
//                        Toast.makeText(ListTripActivity.this,
//                                "open", Toast.LENGTH_SHORT).show();
//                        break;
                    case 0:
                        // delete
                        Toast.makeText(ListTripActivity.this,
                                "delete", Toast.LENGTH_SHORT).show();
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });


//  **********  SwipeMenuListview에 item_trip_list 레이아웃과 TripListAdapter 연결*********

     swipeMenuListView.setAdapter(new TripListAdapter(ListTripActivity.this,
                arrayList_trip,R.layout.item_trip_list ));

    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }


    private  void setToolbar(){
        toolbar_listTrip = (Toolbar)findViewById(R.id.toolbar_listTrip);
        toolbar_listTrip.setTitle("");
        toolbar_listTrip.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
        setSupportActionBar(toolbar_listTrip);
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_list_trip, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.toolbar_item_goto_add_trip:
               Intent intent = new Intent(ListTripActivity.this,
                       AddTripActivity.class);
               startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

