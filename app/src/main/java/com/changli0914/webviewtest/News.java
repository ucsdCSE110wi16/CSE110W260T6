package com.changli0914.webviewtest;

import java.io.Serializable;
import java.util.Date;

/**
 * Class Definition of News (Core Class)
 * Created by Chang Li on 2016/2/9 0009.
 */
class News implements Serializable{

    public String url;
    public String title;
    public NewsSource source;
    public Double bias;
    public Date date;
    public NewsCategory category;
    public NewsRegion region;

    /** Constructor */
    public News(String url, String title) {
        this.url = url;
        this.title = title;
        this.source = NewsSource.Other;
        this.bias = 3.0;
        this.date = new Date();
        this.category = NewsCategory.Other;
        this.region = NewsRegion.NotSpecified;
    }

    public News(String url, String title, NewsSource source, double bias, Date date,
                NewsCategory category, NewsRegion region) {
        this.url = url;
        this.title = title;
        this.source = source;
        this.bias = bias;
        this.date = date;
        this.category = category;
        this.region = region;
    }
}
