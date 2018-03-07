package com.example.a501_10.spinnerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

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

        //3. 어답터 객체만들기(자료를 어답터에 제공)
        arrayAdapter = ArrayAdapter.createFromResource(MainActivity.this,
                R.array.fruits,
                android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //4.스피너 객체에 어답터 객체 등록하기
        spinner_fruits.setAdapter(arrayAdapter);

        //6.리스너객체만들기
        FruitListener fruitListener = new FruitListener();

        //7.리스너를 spinner 객체에 등록하기
        spinner_fruits.setOnItemSelectedListener(fruitListener);

  //5,6,7 통합
        spinner_fruits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(!isInitSpinner){
                    isInitSpinner = true;
                }else{
                 Toast.makeText(MainActivity.this,
                    arrayAdapter.getItem(i).toString(),
                    Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    //5. 리스너 클래스 만들기
    class FruitListener implements Spinner.OnItemSelectedListener{
        //스피너에서 항목이 선택되었을 때, 스피너가 생성될 때
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            if(!isInitSpinner){
                //상황1) spinner가 생성될때
                isInitSpinner = true;
            }else {
                //상황2) spinner 생성 후에 항목이 선택되었을때
                Toast.makeText(MainActivity.this,
                        arrayAdapter.getItem(i).toString(),
                        Toast.LENGTH_LONG).show();
            }
        }
        //스피너에서 항목이 선택되지 않았을 때
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}
