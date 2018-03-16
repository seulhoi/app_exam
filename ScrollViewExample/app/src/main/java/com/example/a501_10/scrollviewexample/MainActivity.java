package com.example.a501_10.scrollviewexample;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView_main;
    LinearLayout linearLayout_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2.컴포넌트 객체 만들기
        scrollView_main = (ScrollView)findViewById(R.id.scrollView_main);
        linearLayout_main = (LinearLayout)findViewById(R.id.linearLayout_main);

        //3.스크롤뷰안에 라이너레이아웃에 추가할 자료 준비하기
        Integer[] imgID = {
                R.drawable.img1,R.drawable.img2,R.drawable.img3,
                R.drawable.img4, R.drawable.img5
        };

        //화면사이즈 구하는 함수
        //디바이스 화면 저옵를 가지고 있는 Display 객체를 가져옴
        Display display = getWindowManager().getDefaultDisplay();
        //화면의 좌표를 가져오기 위한 Point 변수를 만듬
        Point point = new Point();
        //화면의 좌표정보를 가져오는 getSize()함수, point객체에 정보가 저장됨
        display.getSize(point);

        int width = point.x;
        int height = point.y;

        //4.동적으로 뷰를 생성
        for(int i =0; i< imgID.length; i++){
            ImageView temp = new ImageView(MainActivity.this);
            temp.setImageResource(imgID[i]);
            temp.setLayoutParams(new LinearLayout.LayoutParams(width,height));
            temp.setScaleType(ImageView.ScaleType.FIT_XY);

            //5.라이너레이아웃 안에 동적으로 만든 이미지 뷰를 추가
            linearLayout_main.addView(temp);
        }

    }
}
