package com.example.a501_10.app_class_portfolio;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.a501_10.app_class_portfolio.datalist.TripList;
import com.example.a501_10.app_class_portfolio.db.DaoSession;
import com.example.a501_10.app_class_portfolio.db.PortfolioQuery;
import com.example.a501_10.app_class_portfolio.db.Trip;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by 501-10 on 2018-04-03.
 */

public class AddTripActivity extends AppCompatActivity {

    Toolbar toolbar_addTrip;
    EditText editText_addTrip_title, editText_addTrip_startDay, editText_addTrip_endDay,
            editText_addTrip_member, editText_addTrip_money;
    ImageButton btn_addTrip_minus, btn_addTrip_plus;
    int start_year, start_mon, start_day,
            end_year,end_mon,end_day;
    int number_of_member=1;
    DaoSession daoSession;
    ArrayList<Trip> arrayList_trip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);
        daoSession = ((AppController)getApplication()).getDaoSession();
        arrayList_trip = TripList.getInstance();
        setToolber();

        setComponents();


    }

    private void setComponents() {
        editText_addTrip_title
                =(EditText)findViewById(R.id.editText_addTrip_title);
        editText_addTrip_startDay
                =(EditText)findViewById(R.id.editText_addTrip_startDay);
        editText_addTrip_endDay
                =(EditText)findViewById(R.id.editText_addTrip_endDay);
        editText_addTrip_member
                =(EditText)findViewById(R.id.editText_addTrip_member);
        editText_addTrip_money
                =(EditText)findViewById(R.id.editText_addTrip_money);
        btn_addTrip_minus
                =(ImageButton) findViewById(R.id.btn_addTrip_minus);
        btn_addTrip_plus
                =(ImageButton)findViewById(R.id.btn_addTrip_plus);

        // 키보드 안나타나는 설정
        editText_addTrip_startDay.setInputType(InputType.TYPE_NULL);
        editText_addTrip_startDay.setFocusable(false);
        editText_addTrip_endDay.setInputType(InputType.TYPE_NULL);
        editText_addTrip_endDay.setFocusable(false);

        editText_addTrip_startDay.setOnClickListener(new AddTripLisener());
        editText_addTrip_endDay.setOnClickListener(new AddTripLisener());
        btn_addTrip_plus.setOnClickListener(new AddTripLisener());
        btn_addTrip_minus.setOnClickListener(new AddTripLisener());
    }

    class AddTripLisener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.editText_addTrip_startDay:
                    new DatePickerDialog(AddTripActivity.this,
                            dateSetListener,2018,4,10).show();
                    break;
                case R.id.editText_addTrip_endDay:
                    new DatePickerDialog(AddTripActivity.this,
                            dateSetListener2,2018,4,10).show();
                    break;
                case R.id.btn_addTrip_plus:
                    number_of_member++;
                //  editText_addTrip_member.setText(Integer.toString(number_of_member));
                    editText_addTrip_member.setText(number_of_member+ "명");
                    break;
                case R.id.btn_addTrip_minus:
                    number_of_member--;
                    if(number_of_member == 0){
                        number_of_member =1;
                    }
                //   editText_addTrip_member.setText(Integer.toString(number_of_member));
                     editText_addTrip_member.setText(number_of_member+ "명");
                     break;
            }
        }
    }

    private  DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override  //i:년, i1:월, i2:일
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    start_year = i;
                    start_mon = (i1+1);
                    start_day = i2;

                    editText_addTrip_startDay.setText(start_year+"/"+start_mon+"/"+start_day);
                    Log.d("my_select_date", i+"년"+(i1+1)+"월"+i2+"일");
                }
            };

    private  DatePickerDialog.OnDateSetListener dateSetListener2 =
            new DatePickerDialog.OnDateSetListener() {
                @Override  //i:년, i1:월, i2:일
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    end_year = i;
                    end_mon = (i1+1);
                    end_day = i2;

                    editText_addTrip_endDay.setText(end_year+"/"+end_mon+"/"+end_day);
                    Log.d("my_select_date", i+"년"+(i1+1)+"월"+i2+"일");
                }
            };

    private void setToolber() {
        toolbar_addTrip = (Toolbar) findViewById(R.id.toolbar_addTrip);
        toolbar_addTrip.setTitle("");
        toolbar_addTrip.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
        setSupportActionBar(toolbar_addTrip);
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_trip, menu);
        return true;
    }
//    toolbar_item_goto_add_trip
         //   toolbar_item_add_trip
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_item_add_trip:
                PortfolioQuery.insertTrip(daoSession,
                        arrayList_trip,
                        editText_addTrip_title.getText().toString(),
                        new Date(start_year,start_mon,start_day),
                        new Date(end_year,end_mon,end_day),
                        number_of_member,
                        Long.valueOf(editText_addTrip_money.getText().toString())
                        );

                Intent intent = new Intent(AddTripActivity.this, ListTripActivity.class);
                startActivity(intent);

                List<Trip> test = daoSession.getTripDao().queryBuilder().list();
                for(int i =0; i< test.size(); i++){
                    String msg ="trip - " +
                            "id : " + test.get(i).getId() + " / "+
                            "title : " + test.get(i).getTitle()+ "/"+
                            "start_date : " + test.get(i).getStart_day()+ " / " +
                            "end_date : " + test.get(i).getEnd_day() + " / " +
                            "number_of_member" + test.get(i).getNumber_of_member()  + " / " +
                            "total_money : " + test.get(i).getTotal_money() + " / " +
                            "created_at : " + test.get(i).getCreated_at() + " / " +
                            "update_at : " + test.get(i).getUpdated_at() + " / " ;
                            Log.d("DB_input Test", msg);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
