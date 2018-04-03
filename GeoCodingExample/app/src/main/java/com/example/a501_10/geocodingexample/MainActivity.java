package com.example.a501_10.geocodingexample;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_find_addr,btn_find_pos;
    EditText editText_lat, editText_lng, editText_addr;
    TextView textView_result;
    Geocoder geocoder;
    List<Address> addresses = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_find_addr = (Button)findViewById(R.id.btn_find_addr);
        btn_find_pos = (Button)findViewById(R.id.btn_find_pos);
        editText_lat = (EditText)findViewById(R.id.editText_lat);
        editText_lng = (EditText)findViewById(R.id.editText_lng);
        editText_addr = (EditText)findViewById(R.id.editText_addr);
        textView_result = (TextView)findViewById(R.id.textView_result);

        geocoder = new Geocoder(MainActivity.this);

        btn_find_pos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String addr = editText_addr.getText().toString();

                try{
                    //주소로 위도 경도를 얻어올 수 있는 getFromLocationName()함수
                    //검색한 결과를 List<address> 변수에 저장
                    addresses = geocoder.getFromLocationName(addr,1);
                }catch (Exception e){
                }
                if (addresses.size() == 0 || addresses == null){
                    textView_result.setText("검색결과가 없습니다.");
                }else{
                    textView_result.setText(addresses.get(0).getCountryName());
                    //getPhone() >>전화번호
                    //getPostalCode() >>우편번호
                    //getFeatureName() >>명칭
                    //getLatitude() >>위도
                    //getLongitude() >>경도
                }
            }
        });

        btn_find_addr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lat = editText_lat.getText().toString();
                String lng = editText_lng.getText().toString();

                try{
                    //주소로 위도 경도를 얻어올 수 있는 getFromLocationName()함수
                    //검색한 결과를 List<address> 변수에 저장
                    addresses = geocoder.getFromLocation(
                            Double.parseDouble(lat),
                            Double.parseDouble(lng), 5);
                }catch (Exception e){
                    Log.d("Geo",e.getMessage());
                }

                if (addresses.size() == 0 || addresses == null){
                    textView_result.setText("검색결과가 없습니다.");
                }else{
                    textView_result.setText(addresses.get(0).getCountryName());
                    //getCountryName() >> 국가이름
                    //getCountryCode() >> 국가코드
                    //getPhone() >> 전화번호
                    //getPostalCode() >>우편번호
                    //getFeatureName() >>명칭
                    //getLatitude() >>위도
                    //getLongitude() >>경도
                }
            }
        });


    }
}
