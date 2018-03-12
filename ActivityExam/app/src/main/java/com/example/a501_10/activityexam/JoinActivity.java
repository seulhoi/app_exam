package com.example.a501_10.activityexam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by 501-10 on 2018-03-12.
 */

public class JoinActivity extends AppCompatActivity {

    TextView textView_pwinfo;
    EditText editText_id,editText_pw,editText_name,editText_pw2,editText_year,editText_name,editText_phone;
    CheckBox checkBox_m,checkBox_w;
    Spinner spinner_mon,spinner_day;
    Button button_join;
    ArrayAdapter monthAdapter,dayAdapter;


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
        editText_pw.OnFocusChangeListener(pwCheckListener);

    }

    //3.클래스
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
            String user_re_pw = editText_pw2.getText().toString();

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
        editText_pw2 = (EditText)findViewById(R.id.editText_pw2);
        editText_year = (EditText)findViewById(R.id.editText_year);
        editText_phone = (EditText)findViewById(R.id.editText_phone);
        checkBox_m = (CheckBox)findViewById(R.id.checkBox_m);
        checkBox_w = (CheckBox)findViewById(R.id.checkBox_w);
        spinner_mon = (Spinner)findViewById(R.id.spinner_mon);
        spinner_day = (Spinner)findViewById(R.id.spinner_day);
        button_join = (Button)findViewById(R.id.button_join);

    }
    private void setAdapters(){
        monthAdapter = ArrayAdapter.createFromResource(getApplicationContext());

    }
}
