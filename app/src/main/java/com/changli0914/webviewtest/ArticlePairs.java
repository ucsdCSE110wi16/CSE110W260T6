package com.changli0914.webviewtest;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

//import com.changli0914.webviewtest.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by khaldor on 03/02/16.
 */
public class ArticlePairs {
    List<Pair> _pairs;
    int                 _retrieved;


    public List<Pair> getPairs() {
        return (_pairs);
    }

    public ArticlePairs() {
        _pairs = null;
        _retrieved = 0;
    }


    public void buildFromParseObject(ParseObject obj) {
        Pair pair;
        String title;
        String comment;
        Double bias1;
        Double bias2;
        News news1;
        News news2;





        // How i have to put it back.

        title = obj.getString("Title");
        comment = obj.getString("Comment");
        bias1 = obj.getDouble("Bias1");
        bias2 = obj.getDouble("Bias2");
        news1 = (News)Serializer.deserialize(obj.getString("News1").getBytes());
        news2 = (News)Serializer.deserialize(obj.getString("News2").getBytes());

        pair = new Pair(news1, news2, title, comment, 1, 1);


        // Just to see if the this._pairs list has been set.
        if (_pairs == null) {
            _pairs = new ArrayList<Pair>();
        }

        // Debug
        Log.d("SERIALIZE RES", Serializer.deserialize(obj.getBytes("Object")).toString());

        // Deserialize ParseObject passed as parameter, and cast it into a Pair object. (It returns a generic Java Object)
        pair = (Pair)Serializer.deserialize(obj.getBytes("Object"));
        // Add it to our list of pairs.
        _pairs.add(pair);
    }

    public void retrieveNEntries(final int n) {
        List<ParseObject> pairList;
        ParseQuery<ParseObject> query = ParseQuery.getQuery("FieldPair").setLimit(n); // Query for all entries in "ArticlePair" table.

        try {
            pairList = query.find(); // List of parseOBJECTS retrieved from database.

            // Iterate over list. (I miss c++ iterators...)
            for (int i = 0; i < pairList.size(); ++i) {
                Log.d("In LOOP", "Loop : " + i);
                buildFromParseObject(pairList.get(i)); // Call to the function that will pass it from ParseObject to Pair and append it to the this->_pairs List
                _retrieved += 1;
            }
            Log.d("EXE_SUCCESS", _retrieved + " Entries have been fetched.");
        }
        catch (Exception e) {
            Log.e("PARSE_ERROR", e.getMessage());
        }

    }
}
