package com.example.a501_10.checkboxradioexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox_red, checkBox_green;
    RadioButton radioBtn_blue,radioBtn_yellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2.컴포넌트의 객체 만들기
        checkBox_red = (CheckBox)findViewById(R.id.checkBox_red);
        checkBox_green = (CheckBox)findViewById(R.id.checkBox_green);
        radioBtn_blue = (RadioButton)findViewById(R.id.radioBtn_blue);
        radioBtn_yellow = (RadioButton)findViewById(R.id.radioBtn_yellow);

        //4.리스너 객체만들기
        CheckBoxListener checkBoxListener = new CheckBoxListener();
        RadioBtnListener radioBtnListener = new RadioBtnListener();


        //5.
        checkBox_red.setOnCheckedChangeListener(checkBoxListener);
        checkBox_green.setOnCheckedChangeListener(checkBoxListener);
        radioBtn_blue.setOnCheckedChangeListener(radioBtnListener);
        radioBtn_yellow.setOnCheckedChangeListener(radioBtnListener);
    }

    //3.리스너클래스 만들기
    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            switch(compoundButton.getId()){
                case R.id.checkBox_red:
                    Toast.makeText(MainActivity.this,
                            "red",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkBox_green:
                    Toast.makeText(MainActivity.this,
                            "green",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
    class RadioBtnListener  implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            switch(compoundButton.getId()){
                case R.id.radioBtn_blue:
                    Toast.makeText(MainActivity.this,
                            "blue",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radioBtn_yellow:
                    Toast.makeText(MainActivity.this,
                            "yellow",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
