package com.example.a501_10.app_class_portfolio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by 501-10 on 2018-04-03.
 */

public class ListTripActivity extends AppCompatActivity {

    Toolbar toolbar_listTrip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_trip);

        setToolbar();

        toolbar_listTrip = (Toolbar)findViewById(R.id.toolbar_listTrip);
        toolbar_listTrip.setTitle("");
        toolbar_listTrip.setNavigationIcon(R.mipmap.ic_chevron_left_black_24dp);
        setSupportActionBar(toolbar_listTrip);

    }

    private  void setToolbar(){

    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_add_trip, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.toolbar_item_goto_add_trip:
                Toast.makeText(ListTripActivity.this,"여행 추가 페이지로 이동합니다.",
                        Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

