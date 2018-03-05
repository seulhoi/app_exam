package com.example.a501_10.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
 /*
    String[] list_explain = {
            "조선시대의 장군",
            "고구려 19대 왕",
            "조선시대 화가이자 문인",
            "조선왕조 4대 왕"
    };
    */

    //String[] file_explan;
    //String[] file_great;
    String[] movie_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.컴포넌트 배치후 ID 부여
        //2.데이터 생성하기
        //file_explan = getResources().getStringArray(R.array.great_man_explain);
        //file_great = getResources().getStringArray(R.array.great_man);
        movie_title = getResources().getStringArray(R.array.movie_title);

        //3.어답터 만들기
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                MainActivity.this,
                R.array.movie_title,
                android.R.layout.simple_list_item_1);


     /*
        //1.컴포넌트 배치후 ID 부여
        //2.데이터 생성하기
        String[] list ={"이순신","광개토대왕","신사임당","세종대왕"};

        //3.어답터만들기
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1, list);
*/
        //4.리스트뷰의 객체 만들기 findViewById함수:어떤 컴포넌트인지..ID를 검색해서 객체를 만들어줌
        ListView listView = (ListView)findViewById(R.id.listview_greatman);

        //5.리스트뷰에 어댑터 설정하기
        listView.setAdapter(adapter);

        //7.리스너객체 만들기
        MyItemListener myItemListener = new MyItemListener();
        //8.리스트뷰에 리스너 등록하기
        listView.setOnItemClickListener(myItemListener);

        /*// 6,7,8을 통합한 코드 ****
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, file_explan[i],
                        Toast.LENGTH_LONG).show();
            }
        });
*/

    }
     //6.리스너 만들기
     class MyItemListener implements AdapterView.OnItemClickListener{
         @Override
         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             Intent intent = new Intent(MainActivity.this,InfoActivity.class);
             intent.putExtra("movie_index",i);
             startActivityForResult(intent,1);
         }
     }
}
