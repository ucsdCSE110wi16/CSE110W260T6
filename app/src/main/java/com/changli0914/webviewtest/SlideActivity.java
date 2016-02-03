package com.changli0914.webviewtest;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by Administrator on 2016/2/2 0002.
 */
public class SlideActivity extends FragmentActivity {

    private static final int NUM_PAGES = 2;

    private ViewPager mPager;

    private PagerAdapter mPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

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
            SlideFregment fregment = new SlideFregment();
            if (position == 0) {
                fregment.setURL("http://www.foxnews.com/tech/2016/02/02/" +
                        "yahoo-to-cut-1700-workers-as-ceo-tries-to-save-her-own-job.html");
            } else {
                fregment.setURL("http://www.bbc.com/news/business-35479175");
            }
            return fregment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
