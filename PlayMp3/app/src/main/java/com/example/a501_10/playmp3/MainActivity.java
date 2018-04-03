package com.example.a501_10.playmp3;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_play, btn_stop, btn_next, btn_prev;
    TextView textView_title;
    MediaPlayer player;
    ArrayList<String> mp3_paths;
    int play_index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_play = (Button) findViewById(R.id.btn_play);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_prev = (Button) findViewById(R.id.btn_prev);
        textView_title = (TextView) findViewById(R.id.textView_title);
        //음악파일이 저장된 경로를 지정
        mp3_paths = findFileByExt("mp3");


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //play index가 3보다 작은경우(음악파일이 4개있는 상황)
                if (play_index < mp3_paths.size() - 1) {
                    play_index++;
                } else {
                    //play_index 가 3보다 클 경우는 0으로 play_index값을 조정
                    play_index = 0;
                }
                textView_title.setText(mp3_paths.get(play_index));
                //음악 파일의 경로를 MediaPlayer 객체에 등록
                try {
                    if (player.isPlaying()) {
                        player.stop();
                        player.prepare();
                    }
                    player.reset();
                    player.setDataSource(mp3_paths.get(play_index));
                    //음악재생을위한 준비작업을 하는 prepare()함수 호출
                    player.prepare();
                    player.start();
                } catch (Exception e) {
                }
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (play_index > 0) {
                    play_index--;
                } else {
                    play_index = (mp3_paths.size() - 1);
                }
                /*
                play_index = (play_index > 0) ? play_index--: (mp3_paths.size()-1);
                */
                textView_title.setText(mp3_paths.get(play_index));
                //음악 파일의 경로를 MediaPlayer 객체에 등록
                try {
                    if (player.isPlaying()) {
                        player.stop();
                        player.prepare();
                    }
                    player.reset();
                    player.setDataSource(mp3_paths.get(play_index));
                    //음악재생을위한 준비작업을 하는 prepare()함수 호출
                    player.prepare();
                    player.start();
                } catch (Exception e) {
                }
            }
        });
/*
        //음악파일이 저장된 경로를 지정
        String mp3_path = Environment.getExternalStorageDirectory().getAbsolutePath()+
                "/Ringtones/music.mp3";
*/
        //음악 재생을 위한 MediaPlayer 객체를 생성
        player = new MediaPlayer();

        try {
            //음악파일의 경로를 MediaPlayer 객체에 등록
            player.setDataSource(mp3_paths.get(play_index));
            //음악 재생을 위한 준비작업을 하는 prepare() 함수 호출
            player.prepare();
            Log.d("PlayMp3", "mp3 file");
        } catch (Exception e) {
            Log.d("PlayMp3", "mp3 file error");

        }

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //현재 음악파일이 재생되는지 확인할 수 있는 isPlaying() 함수
                //재생여부 확인
                if (player.isPlaying()) {
                    //음악 재생을 일시중지 하기 위한 pause() 함수 호출
                    player.pause();
                    btn_play.setText("play");
                    Log.d("PlayMp3", "mp3 file");
                } else {
                    //음악 재생을 위한 start()함수 호출
                    player.start();
               /*
                    //음악재생을 반복할 경우 setLooping()함수를 활용
                    player.setLooping(true);
                    //음악 파일의 전체 재생 길이
                    int total = player.getDuration();
                    //음악파일을 재생한 길이
                    int pos = player.getCurrentPosition();
                */
                    btn_play.setText("pause");

                }
                textView_title.setText(mp3_paths.get(play_index));
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player.isPlaying()) {
                    //음악 재생을 중지하기 위한 stop() 함수 호출
                    player.stop();
                    try {
                        player.prepare();
                    } catch (Exception e) {
                        Log.d("PlayMp3", "mp3 file error");
                    }
                }

            }
        });
    }

    public void onDestory() {
        super.onDestroy();
        if (player != null) {
            //Mediaplayer 객체를 소멸
            player.release();
        }
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
                    return s.endsWith(file_ext);
                }
            };

            //4. 파일 필터 객체를 활용하여 파일을 검색
            File sdRoot = new File(sd_path);
            String[] jpg_list = sdRoot.list(filter);

            //5. 검색한 파일 리스트를 출력
            String temp = "";
            for (int i = 0; i < jpg_list.length; i++) {
                temp += jpg_list[i] + "\n";
                temp_array.add(sd_path+"/"+jpg_list[i]);
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
