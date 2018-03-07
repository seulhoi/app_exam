package com.example.a501_10.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
        WebView webview_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2.웹뷰 컴포넌트 객체만들기
        webview_test = (WebView)findViewById(R.id.webview_test);

        //3.WebSetting 객체를 통해 웹뷰 설정
        WebSettings webSettings = webview_test.getSettings();
        //자바스크립트 허용
        webSettings.setJavaScriptEnabled(true);
        //새창으로 페이지 로그 방지
        webview_test.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                 view.loadUrl(url);
                 return true;
            }
        });
        //4.웹 페이지 로드
        webview_test.loadUrl("http://www.nate.com");


    }
}
