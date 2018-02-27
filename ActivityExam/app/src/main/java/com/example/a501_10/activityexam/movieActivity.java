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

public class movieActivity extends AppCompatActivity {
    VideoView videoview;
    RatingBar ratingbar;
    Button btn_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        videoview = (VideoView)findViewById(R.id.videoview);
        String uriPath="android.resource://"+getPackageName() +"/"+R.raw.moon;
        Uri uri = Uri.parse(uriPath);
        videoview.setVideoURI(uri);

        final MediaController mediaController = new MediaController(this);
        videoview.setMediaController(mediaController);

        ratingbar =(RatingBar)findViewById(R.id.ratingbar);
        MyListener myListener = new MyListener();
        ratingbar.setOnRatingBarChangeListener(myListener);


        btn_back = (Button)findViewById(R.id.btn_back);
        BtnListner btnListner = new BtnListner();
        btn_back.setOnClickListener(btnListner);

    }
    class MyListener implements RatingBar.OnRatingBarChangeListener{

        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            Toast.makeText(movieActivity.this,
                    Double.toString(v), Toast.LENGTH_SHORT).show();
        }
    }

    class BtnListner implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            finish();
        }
    }

}
