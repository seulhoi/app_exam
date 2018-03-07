package com.example.a501_10.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
        WebView webview_test;
        EditText edittext_url;
        ImageButton imgbtn_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2.웹뷰 컴포넌트 객체만들기
        webview_test = (WebView)findViewById(R.id.webview_test);
        edittext_url = (EditText)findViewById(R.id.edittext_url);
        imgbtn_go = (ImageButton)findViewById(R.id.imgbtn_go);

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

        ImgBtnListener imgBtnListener = new ImgBtnListener();

        imgbtn_go.setOnClickListener(imgBtnListener);


    }

    class ImgBtnListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String url = edittext_url.getText().toString();
            //4.웹 페이지 로드
            webview_test.loadUrl("http://www.nate.com");
        }
    }
}
