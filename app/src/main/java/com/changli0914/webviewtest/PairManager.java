package com.changli0914.webviewtest;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import bolts.Task;

/**
 * TO manage paris. Core methods include:
 *                          getPairs(): Return a random list of pairs to show
 *                          setFilter(): Set a filter to only load related pairs
 *                          cleanFilter(); Remove existed Filter
 *                          addNewPair(): Insert a new created pair into the DB
 *
 *                          WHAT TO DO NEXT:
 *
 *                              Sync With Remote DB (Cache Pairs,Images, etc.)
 *                              Find a Way to Assign an unique ID for each Pair (To enable the sharing of pair)
 *                              Can add new pairs
 *                              Test if new added pair is valid(if the urls can be opened?)
 *
 * Created by Chang Li on 2016/2/9 0009.
 */
public class PairManager implements Serializable {

    private static PairManager pairManager;

    private List<Pair> pairList;

    private ParseQuery<Pair> query;

    private PairManager() {
        pairList = new LinkedList<>();
        query = ParseQuery.getQuery("Pair");
        fetchPairs();
    }

    public static PairManager getPairManager() {
        if (pairManager == null) {
            pairManager = new PairManager();
        }
        return pairManager;
    }

    private void fetchPairs() {
        try {
            Task<List<Pair>> q = query.findInBackground();
            q.waitForCompletion();
            pairList.addAll(q.getResult());
        } catch (Exception e) {
            // Do nothing
        }
    }

    public List<Pair> getPairs() {
        return pairList;
    }

    public Boolean addNewPair(String title, String comment, int image, ParseFile imageFile,
                              Date date, NewsCategory category, NewsRegion region,
                              String url1, String title1, NewsSource source1, Double bias1,
                              String url2, String title2, NewsSource source2, Double bias2) {

        Pair pair = Pair.createPair(title, comment, image, imageFile, date, category, region,
                                    url1, title1, source1, bias1, url2, title2, source2, bias2);
        pairList.add(0, pair);

        return true;
    }
}
