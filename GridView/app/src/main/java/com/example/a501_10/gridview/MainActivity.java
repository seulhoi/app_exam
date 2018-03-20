package com.example.a501_10.gridview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    GridView gridview_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridview_main = (GridView)findViewById(R.id.gridview_main);
        ImageAdapter imageAdapter = new ImageAdapter(MainActivity.this);
        gridview_main.setAdapter(imageAdapter);
    }
        class  ImageAdapter extends BaseAdapter{
            int[] picture = {R.drawable.img1, R.drawable.img2,R.drawable.img3};
            Context context;


            public ImageAdapter(Context context) {
                this.context = context;
            }

            @Override
            public int getCount(){
                return 100;
            }

            @Override
            public Object getItem(int i) {
                return picture[i%3];
            }

            @Override
            public long getItemId(int i) {
               return i;
            }

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
                return null;

            }

    }
}
