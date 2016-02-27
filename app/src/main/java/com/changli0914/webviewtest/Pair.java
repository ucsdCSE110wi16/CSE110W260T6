package com.changli0914.webviewtest;

import android.util.Log;

import com.parse.ParseObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Core Class to stroe information related to a Pair
 * Created by Chang Li on 2016/2/9 0009.
 */

public class Pair implements Serializable{

    protected final String pairID;
    protected final String ownerID;
    protected final Date createdDate;

    protected News news1;
    protected News news2;
    protected NewsRegion region;
    protected String title;
    protected String comment;
    protected int image; // User input.
    protected int likeCount; // User input.
    protected Double bias1;
    protected Double bias2;
    protected NewsCategory category;

    public Pair(News news1, News news2, String title, String comment, int image, int rating) {
        this.news1 = news1;
        this.news2 = news2;
        this.title = title;
        this.comment = comment;
        this.image = image;
        this.bias1 = news1.bias;
        this.bias2 = news2.bias;
        this.likeCount = rating;

        /** These Field Should be Handled Properly in the future */
        // Still didn't really figure out what to do with these fields. Will look in to it eventually.
        this.category = NewsCategory.Entertainment;
        this.region = NewsRegion.US;
        this.pairID = "123";
        this.ownerID = "456";
        this.createdDate = new Date();
    }

    public void put() {
        // Create an ArticlePair ParseObject that will serve to create an entry in the database.
        ParseObject toPut = new ParseObject("FieldPair");
        // Retrieve the serialized object.
        byte[] res = Serializer.serialize(this);

        try {
            // Put the serialized object in the database under the "Object" field
            toPut.put("Title", this.title);
            toPut.put("Comment", this.comment);
            toPut.put("Image", this.image);
            toPut.put("Bias1", this.news1.bias);
            toPut.put("Bias2", this.news2.bias);
            toPut.put("Rating", this.likeCount);

            toPut.put("Category", 0);
            toPut.put("Region", 0);

            toPut.put("News1", Serializer.serialize(this.news1));
            toPut.put("News2", Serializer.serialize(this.news2));
            toPut.save();
        }
        catch (Exception e) {
            Log.e("ERROR : ", e.getMessage(), e);
        }
    }
}
