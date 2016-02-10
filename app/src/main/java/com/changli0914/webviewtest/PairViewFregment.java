package com.changli0914.webviewtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Fragment of PairView. Only Contains a WebView widget.
 * Created by Chang Li on 2016/2/2 0002.
 */
public class PairViewFregment extends Fragment {

    private News news;

    public void setNews(News news) {
        this.news = news;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fregment_pairview, container, false);
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

        myWebView.loadUrl(news.url);

        return myWebView;
    }
}