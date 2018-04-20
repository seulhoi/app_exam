package com.example.a501_10.app_class_portfolio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.a501_10.app_class_portfolio.util.Util;

public class MainActivity extends AppCompatActivity {

    WebView webView_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMainWebView();
    }

//    webView관련 처리
    private void setMainWebView() {
        webView_main = (WebView)findViewById(R.id.webView_main);

        WebSettings webSettings = webView_main.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView_main.setWebViewClient(new WebViewClient(){
            public  boolean shouldOverrideUrlLoading(WebView view, String url){
                if(url.startsWith("app://place1")){
                    Util.setPlaceIndex(MainActivity.this,0);
                    Util.setPlaceTitle(MainActivity.this,"악휘봉");
                    Intent intent = new Intent(MainActivity.this,
                            ListTripActivity.class);
                    startActivity(intent);
                }else if(url.startsWith("app://place2")){
                    Util.setPlaceIndex(MainActivity.this,1);
                       Util.setPlaceTitle(MainActivity.this,"작은 용굴 분수대");
                    Intent intent = new Intent(MainActivity.this,
                            ListTripActivity.class);
                    startActivity(intent);
                }else if(url.startsWith("app://place3")){
                    Util.setPlaceIndex(MainActivity.this,2);
                       Util.setPlaceTitle(MainActivity.this,"문의문화재단지");
                    Intent intent = new Intent(MainActivity.this,
                            ListTripActivity.class);
                    startActivity(intent);
                }else if(url.startsWith("app://place4")){
                    Util.setPlaceIndex(MainActivity.this,3);
                       Util.setPlaceTitle(MainActivity.this,"상수허브랜드");
                    Intent intent = new Intent(MainActivity.this,
                            ListTripActivity.class);
                    startActivity(intent);
                }else if(url.startsWith("app://place5")){
                    Util.setPlaceIndex(MainActivity.this,4);
                       Util.setPlaceTitle(MainActivity.this,"의암 손병희 유허지");
                    Intent intent = new Intent(MainActivity.this,
                            ListTripActivity.class);
                    startActivity(intent);
                }else if(url.startsWith("app://place6")){
                    Util.setPlaceIndex(MainActivity.this,5);
                       Util.setPlaceTitle(MainActivity.this,"대청호");
                    Intent intent = new Intent(MainActivity.this,
                            ListTripActivity.class);
                    startActivity(intent);
                }else{
                    view.loadUrl(url);
                }
                return true;
//                view.loadUrl(url);
//                return true;
            }
        });
        webView_main.loadUrl(DefaultOption.DERAULT_MAIN_PAGE_URL);
      //    webView_main.loadUrl("http://118.46.60.101/index.php");
    }
}
