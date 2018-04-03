package com.example.a501_10.mymapview;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//지도에 마커를 추가하기 위한 OnMapReadyCallBack 클래스를 추가
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fragment Manager 객체를 로드함
        FragmentManager fragmentManager = getFragmentManager();
        //MapFragment 객체를 로드함
        MapFragment mapFragment = (MapFragment)fragmentManager.findFragmentById(R.id.mapView_main);
        //지도 정보를 읽어옴
        mapFragment.getMapAsync(this);
    }

    @Override
    //지도 정보를 다 읽어온 후에 실행하는 onMapReady()함수
    public void onMapReady(GoogleMap googleMap){
        //위도 경도 정보를 저장하고 있는 LatLng 객체를 만듬
        LatLng seoul = new LatLng(37.56, 126.97);

        //지도위에 위치를 표시하는 마커를 생성하는 MarkerOption 객체 생성
        MarkerOptions markerOptions = new MarkerOptions();
        //마커의 위치를 표시하는 position() 함수
        markerOptions.position(seoul);
        //마커가 표시한 위치의 이름을 출력하는 함수 title()함수
        markerOptions.title("서울");
        //마커를 지도에 표시하는 addMarker();
        googleMap.addMarker(markerOptions);

        //특정 좌표가 지도 가운데로 이동하도록 처리
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(seoul));
        // 지도의 배율을 조정하는 zoomTo()함수안의 숫자가 클수록 상세히 보임
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));
    }
}
