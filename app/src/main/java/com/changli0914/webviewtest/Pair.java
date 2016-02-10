package com.changli0914.webviewtest;

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
    protected String title;
    protected String comment;
    protected int image;

    public Pair(News news1, News news2, String title, String comment, int image) {
        this.news1 = news1;
        this.news2 = news2;
        this.title = title;
        this.comment = comment;
        this.image = image;

        /** These Field Should be Handled Properly in the future */
        this.pairID = "123";
        this.ownerID = "456";
        this.createdDate = new Date();
    }
}