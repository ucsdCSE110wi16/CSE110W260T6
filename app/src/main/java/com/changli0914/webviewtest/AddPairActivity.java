package com.changli0914.webviewtest;

import android.app.Activity;
import android.os.Bundle;
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
//emil
public class AddPairActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpair);

        final PairManager pairManager = (PairManager) this.getIntent().getSerializableExtra("pairList");

        Button submitButton = (Button) findViewById(R.id.button_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                News news1 = new News(((EditText)v.findViewById(R.id.add_pair_url1)).getText().toString(),
                        "News 1", NewsSource.Yahoo, 1.0, new Date(), NewsCategory.Politics, NewsRegion.US);
                News news2 = new News(((EditText)v.findViewById(R.id.add_pair_url2)).getText().toString(),
                        "News 2", NewsSource.ABC, 2.0, new Date(), NewsCategory.Science, NewsRegion.World);
                pairManager.addNewPair(new Pair(news1, news2, "Trump and Obama", "1+2", R.drawable.google));
            }
        });
    }

}
