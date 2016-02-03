package com.changli0914.webviewtest;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Administrator on 2016/2/2 0002.
 */
public class SlideFregment extends Fragment {

    private String url = "http://www.google.com/";

    public void setURL(String url) {
        this.url = url;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        ViewGroup rootView = (ViewGroup) inflater.inflate(
//                R.layout.fregment_slide, container, false
//        );

        View v = inflater.inflate(R.layout.fregment_slide, container, false);;
        WebView myWebView = (WebView)v.findViewById(R.id.webView);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        myWebView.loadUrl(url);

        return myWebView;
    }
}
