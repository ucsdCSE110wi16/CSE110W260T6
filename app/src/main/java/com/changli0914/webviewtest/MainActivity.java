package com.changli0914.webviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.parse.ParseObject;

import java.util.Collections;
import java.util.List;

/**
 * This is the main activity of this App.
 *          PairManager: to maintain the pair pool. communicate with Datebase and add new pair
 *          PairList: contains the pairs to show
 *          onCreate():
 *                  initizlize the pair list
 *                  set onClickerListener for ListView and Add Button
 *
 *          TO DO NEXT:
 *                  Add a tool bar to:  Enable user to filter the pairs according to date, category
 *                                      Enable to Refresh and Shuffle
 *
 *           Feb. 10, 2016
 */

public class MainActivity extends AppCompatActivity {

    private PairManager pairManager; /* Manage all pairs (from DB) */
    private List<Pair> pairList; /* Current Pairs List to Show */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Init pairList */
        pairManager = PairManager.getPairManager();
        pairList = pairManager.getPairs();

        /** Find the ListView */
        ListView myListView = (ListView)findViewById(R.id.listView);
        myListView.setAdapter(new MyArrayAdapter(this, pairList));

        /** Find the Add Button */
        ImageButton addButton = (ImageButton) findViewById(R.id.button_add);

        /** Set Click Listener for Add Button */
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                /** Transmit the PairManager to the AddPairActivity */
                intent.setClass(MainActivity.this, AddPairActivity.class);
                /** Start New Avtivity */
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.main_refresh:
                ListView lv = ((ListView) findViewById(R.id.listView));
                Collections.shuffle(pairList);
                lv.setAdapter(new MyArrayAdapter(this, pairList));
                break;
            case R.id.main_filter:
                break;
            case R.id.main_sort:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
