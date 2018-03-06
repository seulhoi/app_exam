package com.example.a501_10.spinnerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spinner_fruits;
    ArrayAdapter arrayAdapter;
    boolean isInitSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. 스피너 객체 만들기
        spinner_fruits = (Spinner)findViewById(R.id.spinner_fruits);

        //3. 어답터 객체만들기
        arrayAdapter = ArrayAdapter.createFromResource(MainActivity.this,
                R.array.fruits,
                android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //4.스피너 객체에 어답터 객체 등록하기
        spinner_fruits.setAdapter(arrayAdapter);
    }

    //5. 리스너 클래스 만들기
    class FruitListener implements Spinner.OnItemSelectedListener{
        //스피너에서 항목이 선택되었을 때, 스피너가 생성될 때
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        }
        //스피너에서 항목이 선택되지 않았을 때
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }


}
