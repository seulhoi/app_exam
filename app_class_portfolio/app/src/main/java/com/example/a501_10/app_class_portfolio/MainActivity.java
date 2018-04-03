package com.example.a501_10.app_class_portfolio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
                if(url.startsWith("app://")){
                    Intent intent = new Intent(MainActivity.this,TestActivity.class);
                    startActivity(intent);
                }else{
                    view.loadUrl(url);
                }return true;

//                view.loadUrl(url);
//                return true;
            }
        });
        webView_main.loadUrl(DefaultOption.DERAULT_MAIN_PAGE_URL);
      //    webView_main.loadUrl("http://118.46.60.101/index.php");
    }
}
