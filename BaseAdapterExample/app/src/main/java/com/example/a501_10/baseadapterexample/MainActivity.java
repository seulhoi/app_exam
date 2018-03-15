package com.example.a501_10.baseadapterexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item_dataFormat> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //arrayList 객체 생성
        arrayList = new ArrayList<Item_dataFormat>();
        arrayList.add(new Item_dataFormat(R.drawable.tulips,
                "갤럭시","삼성"));
        arrayList.add(new Item_dataFormat(R.drawable.ic_launcher_background,
                "아이폰","애플"));
        arrayList.add(new Item_dataFormat(R.drawable.ic_launcher_background,
                "픽셀","구글"));

        ListView listView = (ListView)findViewById(R.id.listview_main);
        listView.setAdapter(new MyItemAdapter(arrayList, this,R.layout.listview_item));
    }

    //항목에 표현할 자료들을 저장하는 객체의 클래스스
   class Item_dataFormat {
        int img;
        String title;
        String sub_title;

        public Item_dataFormat(int img, String title, String sub_title) {
            this.img = img;
            this.title = title;
            this.sub_title = sub_title;
        }
    }
}
