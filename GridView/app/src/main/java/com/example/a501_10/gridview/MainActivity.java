package com.example.a501_10.gridview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gridview_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //그리드 뷰 객체를 만들기
        gridview_main = (GridView)findViewById(R.id.gridview_main);
        //어답터 객체를 생성
        ImageAdapter imageAdapter = new ImageAdapter(MainActivity.this);
        //어답터를 그리드 뷰에 등록
        gridview_main.setAdapter(imageAdapter);

       //그리드 뷰의 리스너 객체를 만듬
        GridListener gridListener = new GridListener();
        //그리드뷰에 리스너 객체를 등록
        // 록
       gridview_main.setOnClickListener(gridListener);
    }
    //그리드 뷰의 리스너 클래스를 만듬
     class GridListener implements AdapterView.OnItemClickListener{
         @Override
         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             Toast.makeText(getApplicationContext(), (i+1)+"번째 그리드,",
                     Toast.LENGTH_LONG).show();
         }
     }

     //어답터의 클래스만들기
        class  ImageAdapter extends BaseAdapter{
            Context context;


            public ImageAdapter(Context context) {
                this.context = context;
            }

            //표현할 그리드의 갯수를 알려주는 함수 == 출력할 자료의 갯수
            @Override
            public int getCount(){
                return 100;
            }

            //그리드안에 넣을 객체(그림 아이디)
            @Override
            public Object getItem(int i) {
                return picture[i%3];
            }

            //그리드의 순서번호(인덱스)
            @Override
            public long getItemId(int i) {
               return i;
            }

            //그리드 뷰 안에 들어갈 이미지를 추가해주는 함수
            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView imageView;

                if(view == null){
                    imageView = new ImageView(context);
                    imageView.setLayoutParams(new GridView.LayoutParams(50,50));
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else {
                    imageView = (ImageView)view;
                }
                imageView.setImageResource(picture[i%3]);
                return null;
          }
     }
}
