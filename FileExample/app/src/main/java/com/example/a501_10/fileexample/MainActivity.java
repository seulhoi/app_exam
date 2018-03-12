package com.example.a501_10.fileexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    Button btn_input, btn_output, btn_del;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_input = (Button)findViewById(R.id.btn_input);
        btn_output = (Button)findViewById(R.id.btn_output);
        btn_del= (Button)findViewById(R.id.btn_del);
        editText = (EditText)findViewById(R.id.editText);

        btn_input.setOnClickListener(new BtnListener());
        btn_output.setOnClickListener(new BtnListener());

    }
//3.리스너 클래스 만들기
    class BtnListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_output:
                    //1.OutputStream을 생성
                    FileOutputStream fos = null;
                    try{
                        //MODE_PRIVATE : 파일을 나만 쓰겠다(권한)
                        fos = openFileOutput("test.txt", Context.MODE_PRIVATE);

                        //2.자료를 빈 파일에 저장함 output은 반드시 byte로 저장됨 그래서 자료형을 바꿔줘야함
                        String str_temp = "파일을 저장하는 예제";
                        fos.write(str_temp.getBytes());

                        //3. OutputStream을 반드시 제거***
                        fos.close();
                    }catch (Exception e){

                    }
                case R.id.btn_input:
                    //1. InputStream을 생성
                    FileInputStream fis = null;
                    byte[] data = null;

                    try{
                        fis = openFileInput("test.txt");
                        //2. 파일에 저장된 데이터를 읽어오기
                        data = new byte[fis.available()];
                        while(fis.read(data) != -1){;}

                        //3.InputStream을 반드시 제거****
                        fis.close();

                        //4.읽어온 데이터를 활용
                        String temp = new String(data);
                        editText.setText(temp);

                    }catch (Exception e){
                        Log.d("file stream","input stream error");
                    }break;
            }
        }
    }
}
