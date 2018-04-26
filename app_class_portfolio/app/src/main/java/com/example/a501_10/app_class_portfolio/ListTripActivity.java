package com.example.a501_10.app_class_portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a501_10.app_class_portfolio.datalist.TripList;
import com.example.a501_10.app_class_portfolio.db.Trip;

import java.util.ArrayList;

/**
 * Created by 501-10 on 2018-04-03.
 */

public class ListTripActivity extends AppCompatActivity {

    Toolbar toolbar_listTrip;
    ListView listView_tripList;
    ArrayList<Trip> arrayList_trip;
    TripListAdapter adapter_tripList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_trip);

        setToolbar();
        setComponents();
        setData();
        setTripList();
    }
    private void setTripList(){
        adapter_tripList = new TripListAdapter(ListTripActivity.this,
                arrayList_trip,R.layout.item_trip_list);
        listView_tripList.setAdapter(adapter_tripList);

        listView_tripList.setOnItemClickListener(
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
    }
    private void setComponents(){
        listView_tripList = (ListView)findViewById(R.id.listView_tripList);
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

