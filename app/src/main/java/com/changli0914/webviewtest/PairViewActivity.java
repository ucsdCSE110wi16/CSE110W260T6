package com.changli0914.webviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

/**
 * Activity to show Pairs, The FragmentActivity is only a Container.
 *
 *              WHAT TO DO NEXT:
 *                      Add a Bar to Show the title
 *                      Show the bias
 *                      Permit the users to rate the news/pair
 *
 * Created by Chang Li on 2016/2/2 0002.
 */
public class PairViewActivity extends FragmentActivity {

    private static final int NUM_PAGES = 2;

    private ViewPager mPager;

    private PagerAdapter mPagerAdapter;

    private Pair pair;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pairview);

        Intent intent = this.getIntent();

        this.pair = (Pair) intent.getSerializableExtra("pair");

        TextView myTextView = (TextView) findViewById(R.id.title_text);

        myTextView.setText(pair.title);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
           mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            PairViewFregment fregment = new PairViewFregment();
            if (position == 0) {
                fregment.setNews(pair.news1);
            } else {
                fregment.setNews(pair.news2);
            }
            return fregment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
