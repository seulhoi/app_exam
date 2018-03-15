package com.example.a501_10.toolbarexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar_main = (Toolbar)findViewById(R.id.toolbar_main);
        toolbar_main.setTitle("");
        setSupportActionBar(toolbar_main);




    }

    //2.툴 바에 실제로 메뉴를 그려넣음
    @Override
    public boolean onCreateOptionsMenu(Menu aMenu) {
       //getMenuInflater: 메뉴를 그려주는 특별한 객체 R.menu:메뉴폴더하위에 있는 파일명, 변수
        getMenuInflater().inflate(R.menu.menu, aMenu);
        return true;
    }


    //1.기능 정의
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_item_select1:
            Toast.makeText(MainActivity.this,"첫번째 버튼을 눌렀습니다.",
                    Toast.LENGTH_LONG).show();
                break;
            case R.id.toolbar_item_select2:
            Toast.makeText(MainActivity.this,"두번째 버튼을 눌렀습니다.",
                    Toast.LENGTH_LONG).show();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
