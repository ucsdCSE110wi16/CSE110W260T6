package com.changli0914.webviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] titles ={"YAHOO CUT 1700 workers\nPair of FOX and BBC", "ABC NEWS", "BBC NEWS"};
        ListView myListView = (ListView)findViewById(R.id.listView);
        myListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles));

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SlideActivity.class);
                startActivity(intent);
            }
        });

    }
}
