package com.changli0914.webviewtest;

import android.app.Activity;
import android.os.Bundle;

import java.util.Date;

/**
 * Created by Amal on 2/29/2016.
 */
public class SearchPairsActivity extends Activity {
    // date, newsSource, bias, rating(missing from pair class), newsRegion, title, newsCategory

    // Each of the News types that make up a pair has a date. Shouldn't the pair have the date
    // field instead.(chang)

    // How should I find pairs when they have two different News types? For e.g should I find the
    // pair if either of news1 & news2 match the  field?

    // Shouldn't the Pair class have the region type instead? A Pair should have 2 News types of
    // the same event, therefore the same region? However, sometimes different regions are involved
    // in one event.

    // Same as above for the category and date. Shouldn't they be part of the pair class?
    // category should be the same for both news1 and news2. Moreover, the user is categorizing
    // the pair when he or she creates it. Same goes for the date of creation of a pair. Although
    // it can be argued that the news types dates are important as well. Does the user care more
    // about the date they saw the pair was added into the app, or the date of the news event?
    // Maybe both?In which case both the News and Pair types will have a date field.

    protected String title = null;
    protected NewsCategory category = null;
    protected NewsSource source = null;
    protected NewsRegion region = null;
    protected int bias = null;
    protected Date date = null;

    // method to display my page and enable the user to select information, look at chang's
    // way of doing it
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchpairs);
    }

    // get the info from the user with some method, buttons, listeners and set variables
    // look at chang's way of doing it

    // initialize query
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Pair");

    if (title != "") {
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
