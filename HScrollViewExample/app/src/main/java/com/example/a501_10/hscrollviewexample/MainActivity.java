package com.example.a501_10.hscrollviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    LinearLayout linearLayout;
    ArrayList<DataFormat> arrayList;
    final int DATA_TYPE_IS_STRING = 0;
    final int DATA_TYPE_IS_IMAGE_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. 스크롤 뷰 안에 배치된 라이너 레이아웃 객체를 만듬
        linearLayout =(LinearLayout)findViewById(R.id.linearLayout);

        //3.스크롤 뷰 안에 표현될 자료 준비하기
        arrayList = new ArrayList<DataFormat>();
        arrayList.add(new DataFormat("My String1"));
        arrayList.add(new DataFormat(R.drawable.img1));
        arrayList.add(new DataFormat("My String2"));
        arrayList.add(new DataFormat(R.drawable.img2));
        arrayList.add(new DataFormat("My String3"));
        arrayList.add(new DataFormat(R.drawable.img3));


        //4.동적으로 컴포넌트 생성하여 라이너레이아웃에 추가하기
        for(int i=0; i < arrayList.size(); i++){
            DataFormat temp = arrayList.get(i);

       // switch (arrayList.get(i).type){
          switch (temp.showDataType()){
            case 0:
                TextView textView = new TextView(MainActivity.this);
                textView.setText(arrayList.get(i).text);
                linearLayout.addView(textView);
                break;
            case 1:
                ImageView imageView = new ImageView(MainActivity.this);
             // imageView.setImageResource(arrayList.get(i).img_id);
                imageView.setImageResource(temp.img_id);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(500,600));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                linearLayout.addView(imageView);
                break;
            }
        }
    }

        //자료를 저장할 객체의 클래스
    class DataFormat{
        int type;
        int img_id;
        String text;

        public DataFormat(String atext){
            type = 0;
            img_id = -1;
            text  = atext;
        }

        public DataFormat(int aImg_id){
            type = 1;
            img_id = aImg_id;
            text  = null;
        }
        public int showDataType(){
            return type;
        }
    }
}
