package com.changli0914.webviewtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

/**
 * Fragment of PairView. Only Contains a WebView widget.
 * Created by Chang Li on 2016/2/2 0002.
 */
public class PairViewFregment extends Fragment {

    private News news;
    private ProgressBar pb;

    public void setNews(News news) {
        this.news = news;
    }
    public void setPb(ProgressBar pb) {this.pb = pb;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fregment_pairview, container, false);
        WebView myWebView = (WebView)v.findViewById(R.id.webView);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.setWebChromeClient(new WebViewClient() );
        myWebView.loadUrl(news.url);

        return myWebView;
    }

    private class WebViewClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            pb.setProgress(newProgress);
            if (newProgress == 80) {
                pb.setVisibility(View.GONE);
            }
            super.onProgressChanged(view, newProgress);
        }
    }
}