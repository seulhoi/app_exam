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

public class SecondActivity extends AppCompatActivity {

    VideoView videoView_second;
    Button btn_second_to_main;
    RatingBar ratingbar_second;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //1. 레이아웃에서 video ID설정하기
        //2.videoview 객체 만들기
        videoView_second = (VideoView)findViewById(R.id.videoView_second);
        //3. 동영강 파일 경로 설정하기 (R.raw.동영상이름)
        String uriPath ="android.resource://"+getPackageName() + "/"+R.raw.graphic;
        //4.uri로 동영상 연결하기
        Uri uri = Uri.parse(uriPath);
        //5. videoview 객체에 uri(동영상의 정보) 등록하기
        videoView_second.setVideoURI(uri);

        //6. 동영상을 컨트롤 할 수 있는 media controller를 videoview에 추가하기
        final  MediaController mediaController = new MediaController(this);
        videoView_second.setMediaController(mediaController);

        btn_second_to_main  = (Button)findViewById(R.id.btn_second_to_main);
        MyListener myListener = new MyListener();
        btn_second_to_main.setOnClickListener(myListener);

        ratingbar_second = (RatingBar)findViewById(R.id.ratingbar_second);
        RatingListener ratingListener = new RatingListener();
        ratingbar_second.setOnRatingBarChangeListener(ratingListener);

    }
    class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            finish();
        }
    }
    class RatingListener implements RatingBar.OnRatingBarChangeListener{

        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            Toast.makeText(SecondActivity.this,
                    Double.toString(v), Toast.LENGTH_LONG).show();
        }
    }

}
