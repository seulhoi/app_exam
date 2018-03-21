package com.example.a501_10.sdcardexample;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_find_music, btn_find_img;
    TextView textView_main;
    ArrayList<String> img_array, music_array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_find_music = (Button)findViewById(R.id.btn_find_music);
        btn_find_img = (Button)findViewById(R.id.btn_find_img);
        textView_main = (TextView)findViewById(R.id.textView_main);

        btn_find_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_array = findFileByExt("jpg");

                for(int i = 0; i <img_array.size(); i++){
                   String temp = textView_main.getText().toString();
                   textView_main.setText(temp + img_array.get(i) + "\n");
                }
            }
        });

        btn_find_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                music_array = findFileByExt("mp3");

                for(int i = 0; i < music_array.size(); i++){
                    String temp = textView_main.getText().toString();
                    textView_main.setText(temp + img_array.get(i) + "\n");
                }
            }
        });

    }


    private ArrayList<String> findFileByExt(String ext) {
        ArrayList<String> temp_array = new ArrayList<String>();
        final String file_ext = ext;

        // 1. SD카드가 인식되어있는지 확인한다: getExternalStorageState()함수사용
        // 인식이 된 경우에는 getExternalStorageState() 함수가 Environment.MEDIA_MOUNTED 값을 리턴
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {

            //2.SD카드의 폴더의 주소를 가져옴
            String sd_path = Environment.getExternalStorageDirectory()
                    .getAbsolutePath();

            //3.찾고자 하는 파일의 확장자를 검색해주는 필터 객체를 생성
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File file, String s) {
                    return s.endsWith("file_ext");
                }
            };

            //4. 파일 필터 객체를 활용하여 파일을 검색
            File sdRoot = new File(sd_path);
            String[] jpg_list = sdRoot.list(filter);

            //5. 검색한 파일 리스트를 출력
            String temp = "";
            for (int i = 0; i < jpg_list.length; i++) {
                temp += jpg_list[i] + "\n";
                temp_array.add(jpg_list[i]);
            }
            return temp_array;
        } else {
            Toast.makeText(getApplicationContext(),
                    "SD 카드 인식이 안됨",
                    Toast.LENGTH_LONG).show();
            return null;
        }
    }
}
