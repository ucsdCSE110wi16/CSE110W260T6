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
import android.widget.TextView;

/**
 * Fragment of PairView. Only Contains a WebView widget.
 * Created by Chang Li on 2016/2/2 0002.
 */
public class PairViewFragment extends Fragment {

    private Pair pair;
    private int id;
    private ProgressBar progressBar;

    public void setID(int id) {
        this.id = id;
    }
    public void setPair(Pair pair) { this.pair = pair; }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        /* Inflate View */
        View v = inflater.inflate(R.layout.fregment_pairview, container, false);

        /* Set News title */
        TextView textView = (TextView)v.findViewById(R.id.title_fragment);
        textView.setText(pair.getTitle(id));

        /* Init the Progress Bar for the web page loading */
        progressBar = (ProgressBar)v.findViewById(R.id.pb);
        progressBar.setMax(100);

        /* Init WebView and Load Target URL */
        WebView myWebView = (WebView)v.findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebChromeClient(new WebViewClient());
        myWebView.loadUrl(pair.getUrl(id));

        /* Init Bias Rating Bar (A Seek Bar) */


        return v;
    }

    /* Viewer must finish reading article before deciding on bias */
    /*@Override
    public void onScroll(int l, int t) {
        int height = (int) Math.floor(webView.getContentHeight() * webView.getScale());
        int webViewHeight = webView.getHeight();
        int cutoff = height - webViewHeight - 10; // Don't be too strict on the cutoff point
        if (t >= cutoff) {
            setDisclaimerButtonEnabled(true);
        }
    }*/

    /* WebChromeClient is needed to use ProgressBar */
    private class WebViewClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            /* Override to update progress */
            progressBar.setProgress(newProgress);
            if (newProgress == 100) {
                progressBar.setVisibility(View.GONE);
            }
            super.onProgressChanged(view, newProgress);
        }
    }
}