package com.changli0914.webviewtest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Daniel on 2/14/2016.
 */
public class PairViewTitleFrag extends Fragment {

    private News news;

    public void setNews( News news ) {this.news = news;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_pairview_title, container, false);
        TextView myTextView = (TextView) v.findViewById(R.id.textView4);

        myTextView.setText(news.title);

        return myTextView;
    }
}
