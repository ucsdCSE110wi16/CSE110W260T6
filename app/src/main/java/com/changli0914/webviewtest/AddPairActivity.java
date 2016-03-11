package com.changli0914.webviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

/**
 * The activity to enable user to create their own Pair
 * There are bugs now. We cannot add Pairs successfully.
 * The architecture may need to be modified: Don't use the PairManager to add Pair?
 *
 * Created by Chang Li on 2016/2/9 0009.
 */
public class AddPairActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpair);

        //final PairManager pairManager = (PairManager) this.getIntent().getSerializableExtra("pairList");

        EditText title = (EditText)findViewById(R.id.add_pair_title);
        EditText subtitle1 = (EditText)findViewById(R.id.add_pair_subtitle1);
        EditText subtitle2 = (EditText)findViewById(R.id.add_pair_subtitle2);
        EditText url1 = (EditText)findViewById(R.id.add_pair_url1);
        EditText url2 = (EditText)findViewById(R.id.add_pair_url2);

        Button submitButton = (Button) findViewById(R.id.button_submit);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PairManager.getPairManager().addNewPair(
                                        ((EditText)findViewById(R.id.add_pair_title)).getText().toString(),
                                        "Just for test", R.drawable.google, null,
                                        new Date(), NewsCategory.Politics, NewsRegion.US,
                                        ((EditText)findViewById(R.id.add_pair_url1)).getText().toString(),
                                        "News 1", NewsSource.Yahoo, 1.0,
                                        ((EditText)findViewById(R.id.add_pair_url2)).getText().toString(),
                                        "News 2", NewsSource.ABC, 2.0);
                finish();
            }
        });
    }



}
