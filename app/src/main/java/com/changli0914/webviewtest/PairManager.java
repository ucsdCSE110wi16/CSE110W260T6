package com.changli0914.webviewtest;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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

    private List<Pair> list = new LinkedList<>();

    //(String url, String title, NewsSource source, double bias, Date date, NewsCategory category, NewsRegion region)
    public List<Pair> getPairs() {

        News news1 = new News("http://www.foxnews.com/politics/2016/02/09/" +
                "trump-on-possible-bloomberg-run-would-love-to-see-it.html", "Trump On Possible Bloomberg",
                NewsSource.Fox, 1.0, new Date(), NewsCategory.Politics, NewsRegion.US);
        News news2 = new News("http://www.foxnews.com/politics/2016/02/09/" +
                "obama-sends-congress-record-4-1t-budget-plan.html", "Obama Sends Congress Record",
                NewsSource.ABC, 2.0, new Date(), NewsCategory.Science, NewsRegion.World);
        News news3 = new News("https://www.yahoo.com/politics/" +
                "hillarys-millennial-woman-problem-010617452.html", "Hillarys Millennial Woman Problem",
                NewsSource.Fox, 4.0, new Date(), NewsCategory.Health, NewsRegion.US);
        News news4 = new News("https://www.yahoo.com/politics/ivanka-with-her-bump-stumps-fo" +
                "r-papa-trump-211443177.html", "Ivanka With Her Bump Stumps For Papa Trump",
                NewsSource.BBC, 5.0, new Date(), NewsCategory.Entertainment, NewsRegion.World);

        list.add(new Pair(news1, news2, "Trump and Obama", "1+2", R.drawable.obama_1));
        list.add(new Pair(news1, news3, "Trump and Hillarys", "1+3", R.drawable.hillary_1));
        list.add(new Pair(news1, news4, "Trump and Trump", "1+4", R.drawable.trump_1));
        list.add(new Pair(news2, news3, "Obama and Hillarys", "2+3", R.drawable.obama_2));
        list.add(new Pair(news2, news4, "Obama and Trump", "2+4", R.drawable.obama_3));
        list.add(new Pair(news3, news4, "Hillary and Obama", "3+4", R.drawable.hillary_2));
        list.add(new Pair(news1, news2, "Trump and Obama", "1+2", R.drawable.trump_3));
        list.add(new Pair(news1, news3, "Trump and Hillarys", "1+3", R.drawable.trump_4));
        list.add(new Pair(news1, news4, "Trump and Trump", "1+4", R.drawable.trump_2));
        list.add(new Pair(news2, news3, "Obama and Hillarys", "2+3", R.drawable.hillary_1));
        list.add(new Pair(news2, news4, "Obama and Trump", "2+4", R.drawable.obama_1));
        list.add(new Pair(news3, news4, "Hillary and Obama", "3+4", R.drawable.hillary_2));

        return list;
    }

    public Boolean setFilterByDate(Date start, Date end) {
        return true;
    }

    public Boolean cleanFilter() {
        return true;
    }

    public Boolean addNewPair(Pair pair) {
        list.add(0, pair);
        return true;
    }
}
