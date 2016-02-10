package com.changli0914.webviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

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

    private PairManager pairManager = new PairManager(); /* Manage all pairs (from DB) */
    private List<Pair> pairList; /* Current Pairs List to Show */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Init pairList */
        pairList = pairManager.getPairs();

        /** Find the ListView */
        ListView myListView = (ListView)findViewById(R.id.listView);
        myListView.setAdapter(new MyArrayAdapter(this, pairList));

        /** Set Click Listener for Each Item */
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                /** Transmit the Target Pair to the PairViewActivity */
                intent.putExtra("pair", pairList.get(position));
                intent.setClass(MainActivity.this, PairViewActivity.class);
                /** Start The PairViewActivity */
                startActivity(intent);
            }
        });

        /** Find the Add Button */
        ImageButton addButton = (ImageButton) findViewById(R.id.button_add);

        /** Set Click Listener for Add Button */
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                /** Transmit the PairManager to the AddPairActivity */
                intent.putExtra("pairManager", pairManager);
                intent.setClass(MainActivity.this, AddPairActivity.class);
                /** Start New Avtivity */
                startActivity(intent);
            }
        });

    }

}