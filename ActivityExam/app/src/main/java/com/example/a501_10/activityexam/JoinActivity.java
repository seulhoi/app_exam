package com.example.a501_10.activityexam;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;

/**
 * Created by 501-10 on 2018-03-12.
 */

public class JoinActivity extends AppCompatActivity {

    TextView textView_pwinfo;
    EditText editText_id,editText_pw,editText_repw,editText_year,editText_name,editText_phone;
    CheckBox checkBox_m,checkBox_w;
    Spinner spinner_mon,spinner_day;
    Button button_join;
    ArrayAdapter monthAdapter,dayAdapter;

    Boolean isIdChecked;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);


        //2.컴포넌트의 객체만들기
        setComponent();
        //스피너 관련 처리함수
        setAdapters();

        //4.
         IdCheckListener idCheckListener = new IdCheckListener();
        PwCheckListener pwCheckListener = new PwCheckListener();

        //5.
        editText_id.setOnFocusChangeListener(idCheckListener);
        editText_repw.setOnFocusChangeListener(pwCheckListener);

        button_join.setOnClickListener(new JoinBtnListener());
    }

    //3.클래스
    class JoinBtnListener implements  View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(isIdChecked){
                String temp_id = editText_id.getText().toString();
                //output stream을 생성
                FileOutputStream fos = null;
                try{
                    fos = openFileOutput("id.bin", Context.MODE_PRIVATE);
                    //비어있는 파일에 아이디를 저장
                    fos.write(temp_id.getBytes());
                    //output stream 제거
                    fos.close();
                }catch (Exception e) {}
            }else{
                Toast.makeText(JoinActivity.this,"정상적인 아이디를 입력하세요",
                        Toast.LENGTH_SHORT).show();

            }

            if(editText_name.getText().toString().equals("") &&
                    editText_phone.getText().toString().equals("")){
                SharedPreferences pref = getSharedPreferences("user_info", 0);
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("user_name",editText_name.getText().toString());
                editor.putString("user_phone",editText_phone.getText().toString());

                editor.commit();

                SharedPreferences pref_read = getSharedPreferences("user_info",0);
                String user_name = pref_read.getString("user_name","error");
                String user_phone = pref_read.getString("user_phone","error");

            }else{
                Toast.makeText(JoinActivity.this, "이름, 전화번호를 확인하세요",
                        Toast.LENGTH_SHORT).show();
            }

        }
    }

    class IdCheckListener implements View.OnFocusChangeListener{

        @Override
        public void onFocusChange(View view, boolean b) {
            String user_input_id = editText_id.getText().toString();
            int num_of_id = user_input_id.length();
            if(num_of_id >= 5){
                if(num_of_id <= 12){
                    textView_pwinfo.setText("정상적인 아이디입니다.");
                    }else{
                    textView_pwinfo.setText("비정상적인 아이디입니다.(12보다 작아야합니다)");
                }
            }else{
                textView_pwinfo.setText("비 정상적인 아이디입니다.(5보다 커야합니다)");
            }

            /*
            if(num_of_id >= 5 && num_of_id){
             textView_pwinfo.setText("정상적인 아이디입니다.");
             }else{
                textView_pwinfo.setText("비 정상적인 아이디입니다.");
             }
             */

        }
    }

    class PwCheckListener implements  View.OnFocusChangeListener{

        @Override
        public void onFocusChange(View view, boolean b) {
            String user_pw = editText_pw.getText().toString();
            String user_re_pw = editText_repw.getText().toString();

            if(user_pw.equals(user_re_pw)){
                textView_pwinfo.setText("정상적인 비밀번호입니다.");
            }else{
                textView_pwinfo.setText("비밀번호가 일치하지않습니다.");
            }
        }
    }

    private void setComponent(){
        textView_pwinfo = (TextView)findViewById(R.id.textView_pwinof);
        editText_id = (EditText)findViewById(R.id.editText_id);
        editText_pw = (EditText)findViewById(R.id.editText_pw);
        editText_name = (EditText)findViewById(R.id.editText_name);
        editText_repw = (EditText)findViewById(R.id.editText_repw);
        editText_year = (EditText)findViewById(R.id.editText_year);
        editText_phone = (EditText)findViewById(R.id.editText_phone);
        checkBox_m = (CheckBox)findViewById(R.id.checkBox_m);
        checkBox_w = (CheckBox)findViewById(R.id.checkBox_w);
        spinner_mon = (Spinner)findViewById(R.id.spinner_mon);
        spinner_day = (Spinner)findViewById(R.id.spinner_day);
        button_join = (Button)findViewById(R.id.button_join);

    }
    private void setAdapters(){
        monthAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.month_info,
                android.R.layout.simple_spinner_item);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_mon.setAdapter(monthAdapter);
        spinner_mon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dayAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.day_info,
                android.R.layout.simple_spinner_item);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_day.setAdapter(dayAdapter);
        spinner_day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
