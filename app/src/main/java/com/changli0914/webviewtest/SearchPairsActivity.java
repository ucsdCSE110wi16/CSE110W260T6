package com.changli0914.webviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Date;

/**
 * Created by Amal on 2/29/2016.
 */
public class SearchPairsActivity extends Activity {

    protected String title = "";
    protected NewsCategory category = NewsCategory.NotSpecified;
    //protected NewsSource source = NewsSource.NotSpecified; /* not included in our DB */
    protected NewsRegion region = NewsRegion.NotSpecified;
    protected Double bias = 0;
    //protected Date date = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchpairs);

        //list of pairs
        //counter
        EditText title;
        Spinner category_spinner, region_spinner, bias_spinner;
        ArrayAdapter<NewsCategory> category_adapter;
        ArrayAdapter<NewsRegion> region_adapter;
        ArrayAdapter<int> bias_adapter;
        //date field initialization
        //buttons cancel submit

        //title handling

        category_adapter = new ArrayAdapter<NewsCategory>(this, android.R.layout.simple_spinner_item, NewsCategory.values());
        category_spinner = (Spinner) findViewById(R.id.search_pair_category);
        category_spinner.setAdapter(category_adapter);

        category_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category = parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                category = NewsCategory.NotSpecified;
            }
        });

        region_adapter = new ArrayAdapter<NewsRegion>(this, android.R.layout.simple_spinner_item, NewsRegion.values());
        region_spinner = (Spinner) findViewById(R.id.search_pair_region);
        region_spinner.setAdapter(region_adapter);

        region_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                region = parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                region = NewsRegion.NotSpecified;
            }
        });

        bias_spinner = (Spinner) findViewById(R.id.bias);
        bias_adapter = ArrayAdapter.createFromResource(this, R.array.biases, android.R.layout.simple_spinner_item);
        bias_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bias_spinner.setAdapter(bias_adapter);

        category_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bias = parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                bias = 0;
            }
        });

        Button submitButton = (Button) findViewById(R.id.search_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // initialize query
                //ParseQuery<ParseObject> query = ParseQuery.getQuery("Pair");

                /*if (title != "") {
                    query.WhereContains("Title", title);
                }

                if (category != All) {
                    query.WhereEqualTo("Category", category);
                }

                if (source != All) {
                    query.WhereEqualTo("Source", source);
                }

                if (region != All) {
                    query.WhereEqualTo("Region", region);
                }

                if (bias != -1) { // set bias to -1 before the listener finds out the val from user
                    query.WhereEqualTo("Bias1", bias);  // probably need to have the pair know about
                    // news1 and news2 biases
                    query.WhereEqualTo("Bias2", bias);
                }

                if (date != null) {
                    query.WhereEqualTo("Date", date);
                }*/

                /*String title = "test";
                String comment = "test too";
                Pair created;
                String url1;
                String url2;
                //  title =  ((EditText)v.findViewById(R.id.add_pair_title)).getText().toString();
                // comment = ((EditText)v.findViewById(R.id.add_pair_comment)).getText().toString();
                url1 = url1_field.getText().toString();
                url2 = url2_field.getText().toString();

                News news1 = new News(url1, "News 1", NewsSource.Yahoo, 1.0, new Date(), NewsCategory.Politics, NewsRegion.US);
                News news2 = new News(url2, "News 2", NewsSource.ABC, 2.0, new Date(), NewsCategory.Science, NewsRegion.World);
                created = new Pair(news1, news2, title, comment, R.drawable.google, 1);
                //pairManager.addNewPair(created);
                Log.d("Before put", "Putput");
                created.put();*/
            }
        });

        //cancel button
    }

    // display results when done, look up how to display

    // display only 10 at a time but find 100 (use the setLimit() method)
    // use set limit 100 and iterate to show 10 of results per page:
    // results = 1st 10, result = 2nd 10, ...
    // when 100 is reached iterate skipping 100,skip += 100 (use the setSkip() method)
    // if possible make a check to show results after the last item shown (there might be new
    // items added to the data base, which would result in the same items as the last search
    // showing up again (would only matter if so many users uploading pairs at the moment)
}
