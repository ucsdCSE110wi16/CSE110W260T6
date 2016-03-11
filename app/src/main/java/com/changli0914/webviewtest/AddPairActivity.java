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

<<<<<<< HEAD

        final EditText title = ((EditText) findViewById(R.id.add_pair_title));
        final EditText comment = ((EditText) findViewById(R.id.add_pair_comment));
        final EditText url1_field = (EditText) findViewById(R.id.add_pair_url1);
        final EditText url2_field = (EditText) findViewById(R.id.add_pair_url2);


        // final PairManager pairManager = (PairManager) this.getIntent().getSerializableExtra("pairList");
=======
        //final PairManager pairManager = (PairManager) this.getIntent().getSerializableExtra("pairList");

        EditText title = (EditText)findViewById(R.id.add_pair_title);
        EditText subtitle1 = (EditText)findViewById(R.id.add_pair_subtitle1);
        EditText subtitle2 = (EditText)findViewById(R.id.add_pair_subtitle2);
        EditText url1 = (EditText)findViewById(R.id.add_pair_url1);
        EditText url2 = (EditText)findViewById(R.id.add_pair_url2);
>>>>>>> c34e6e92e09e13be3a0404e79c6839651075397b

        Button submitButton = (Button) findViewById(R.id.button_submit);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

<<<<<<< HEAD
                String title = "test";
                String comment = "test too";
                Pair created;
                String url1;
                String url2;
                //  title =  ((EditText)v.findViewById(R.id.add_pair_title)).getText().toString();
                // comment = ((EditText)v.findViewById(R.id.add_pair_comment)).getText().toString();
                url1 = url1_field.getText().toString();
                url2 = url2_field.getText().toString();

                News news1 = new News(url1,"News 1", NewsSource.Yahoo, 1.0, new Date(), NewsCategory.Politics, NewsRegion.US);
                News news2 = new News(url2,"News 2", NewsSource.ABC, 2.0, new Date(), NewsCategory.Science, NewsRegion.World);
                created = new Pair(news1, news2, title, comment, R.drawable.google, 1);
                //pairManager.addNewPair(created);
                Log.d("Before put", "Putput");
                created.put();
=======
                PairManager.getPairManager().addNewPair(
                                        ((EditText)findViewById(R.id.add_pair_title)).getText().toString(),
                                        "Just for test", R.drawable.google, null,
                                        new Date(), NewsCategory.Politics, NewsRegion.US,
                                        ((EditText)findViewById(R.id.add_pair_url1)).getText().toString(),
                                        "News 1", NewsSource.Yahoo, 1.0,
                                        ((EditText)findViewById(R.id.add_pair_url2)).getText().toString(),
                                        "News 2", NewsSource.ABC, 2.0);
                finish();
>>>>>>> c34e6e92e09e13be3a0404e79c6839651075397b
            }
        });
    }



}
