package com.changli0914.webviewtest;


import android.util.Log;

import com.parse.ParseObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import com.parse.ParseACL;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;


import java.util.Date;

/**
 * Core Class to stroe information related to a Pair
 * Created by Chang Li on 2016/2/9 0009.
 */

@ParseClassName("Pair")
public class Pair extends ParseObject{

    // public final String pairID; ------> pairID == ParseObject ID
    // public final Date createdDate; -------> date = ParseObject Create Date

    // public String title;
    public void setTitle(String title) {
        put("title", title);
    }
    public String getTitle() {
        return getString("title");
    }

    // public String comment;
    public void setComment(String comment) {
        put("comment", comment);
    }
    public String getComment() {
        return getString("comment");
    }

    // public int image;
    public void setImage(int image) {
        put("image", image);
    }
    public int getImage() {
        return getInt("image");
    }

    // public ParseFile imageFile;
    public void setImageFile(ParseFile imageFile) {
        put("imageFile", imageFile);
    }
    public ParseFile getImageFile() {
        return getParseFile("imageFile");
    }

    // public int likeCount;
    public void setLikeCount(int likeCount) {
        put("likeCount", likeCount);
    }
    public int getLikeCount() {
        return getInt("likeCount");
    }

    // public Date date;
    public void setDate(Date date) {
        put("date", date);
    }
    public Date getDate() {
        return getDate("date");
    }

    // public NewsCategory category;
    public void setNewsCategory(NewsCategory newsCategory) {
        put("category", NewsCategory.categoryToInt(newsCategory));
    }
    public NewsCategory getNewsCategory() {
        return NewsCategory.intToCategory(getInt("category"));
    }

    // public NewsRegion region;
    public void setNewsRegion(NewsRegion region) {
        put("region", NewsRegion.regionToInt(region));
    }
    public NewsRegion getNewsRegion() {
        return NewsRegion.intToRegion(getInt("region"));
    }

    /** News 1 */

    /*
    public String url1;
    public String title1;
    public NewsSource source1;
    public Double bias1;
    */

    /** News 2 */

    /*
    public String url2;
    public String title2;
    public NewsSource source2;
    public Double bias2;
    */

    // String url1, url2
    public void setUrl(String url, int id) {
        put("url"+id, url);
    }
    public String getUrl(int id) {
        return getString("url"+id);
    }

    // String title1, title2
    public void setTitle(String title, int id) {
        put("title"+id, title);
    }
    public String getTitle(int id) {
        return getString("title"+id);
    }

    // NewsSource source1, source2
    public void setSource(NewsSource source, int id) {
        put("source"+id, NewsSource.sourceToInt(source));
    }
    public NewsSource getSource(int id) {
        return NewsSource.intToSource(getInt("source" + id));
    }

    // double bias1, bias2
    public void setBias(Double bias, int id) {
        put("bias"+id, bias);
    }
    public double getBias(int id) {
        return getDouble("bias" + id);
    }

    /**
     * All Pair Instance should be created with this method.
     */


    public static Pair createPair(String title, String comment, int image, ParseFile imageFile,
                Date date, NewsCategory category, NewsRegion region,
                String url1, String title1, NewsSource source1, Double bias1,
                String url2, String title2, NewsSource source2, Double bias2) {

        Pair pair = new Pair();

        pair.setTitle(title);
        pair.setComment(comment);
        pair.setImage(image);
        //pair.setImageFile(imageFile);

        pair.setLikeCount(new Random().nextInt(10000));
        pair.setDate(date);
        pair.setNewsCategory(category);
        pair.setNewsRegion(region);

        pair.setUrl(url1, 1);
        pair.setTitle(title1, 1);
        pair.setSource(source1, 1);
        pair.setBias(bias1, 1);

        pair.setUrl(url2, 2);
        pair.setTitle(title2, 2);
        pair.setSource(source2, 2);
        pair.setBias(bias2, 2);

        ParseACL acl = new ParseACL();
        acl.setPublicReadAccess(true);
        acl.setPublicWriteAccess(true);
        pair.setACL(acl)
        ;
        pair.saveInBackground();

        return pair;
    }

}
