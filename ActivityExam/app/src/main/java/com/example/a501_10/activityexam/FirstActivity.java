package com.example.a501_10.activityexam;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by 501-10 on 2018-02-27.
 */

public class FirstActivity extends AppCompatActivity {

    VideoView videoView_first;
    Button btn_first_to_main;
    RatingBar ratingbar_first;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //1. 레이아웃에서 video ID설정하기
        //2.videoview 객체 만들기
        videoView_first = (VideoView)findViewById(R.id.videoView_first);

        //3. 동영강 파일 경로 설정하기 (R.raw.동영상이름)
        String uriPath ="android.resource://"+getPackageName() + "/"+R.raw.moon;

        //4.uri로 동영상 연결하기
        Uri uri  = Uri.parse(uriPath);

        //5. videoview 객체에 uri(동영상의 정보) 등록하기
        videoView_first.setVideoURI(uri);

        //6. 동영상을 컨트롤 할 수 있는 media controller를 videoview에 추가하기
        final MediaController mediaController = new MediaController(this);
        videoView_first.setMediaController(mediaController);

        //*2.컴포넌트의 객체만들기
        btn_first_to_main = (Button)findViewById(R.id.btn_first_to_main);
        //*4.리스너 객체 만들기
        FirstToMainListener firstToMainListener = new FirstToMainListener();
        //*5.리스너를 컴포넌트의 객체에 등록
        btn_first_to_main.setOnClickListener(firstToMainListener);

        ratingbar_first = (RatingBar)findViewById(R.id.ratingbar_first);
        RatingListener ratingListener = new RatingListener();
        ratingbar_first.setOnRatingBarChangeListener(ratingListener);

        }
    //*3.리스너만들기
    class FirstToMainListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //*현재 화면을 제거하는 함수
            finish();
        }
    }

    class RatingListener implements RatingBar.OnRatingBarChangeListener{
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        Toast.makeText(FirstActivity.this,
                Double.toString(v), Toast.LENGTH_LONG).show();
        }
    }

}
