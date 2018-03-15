package com.example.a501_10.preferenceexample;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn_save, btn_load;

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        btn_save = (Button)findViewById(R.id.btn_save);
        btn_load = (Button)findViewById(R.id.btn_load);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("file_name",0);
                SharedPreferences.Editor editor = pref.edit();

                //저장할 데이터를 준비
                editor.putString("test_string","저장하고 싶은 값");
                editor.putString("test_string2","또 저장하는 값");
                editor.putInt("test_string3",100);
                editor.putString("my_String",editText.getText().toString());
                editText.setText("");

                //데이터를 프래퍼런스에 저장
                editor.commit();
            }
        });

        btn_load.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //프래너퍼런스 객체생성
                SharedPreferences pref = getSharedPreferences("file_name",0);

                //데이터 읽어오기
                String temp1 = pref.getString("test_string","default_string");
                String temp2 = pref.getString("test_string2","default_string2");
                int temp3 = pref.getInt("test_string3",-1);
                String temp4 = pref.getString("my_string","no_data");

                editText.setText(temp4);
            }
        });
    }
}
