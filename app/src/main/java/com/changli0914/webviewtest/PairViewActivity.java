package com.changli0914.webviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity to show Pairs, The FragmentActivity is only a Container.
 *
 *              WHAT TO DO NEXT:
 *                      Add a Bar to Show the title (DONE Deb. 17)
 *                      Show the bias
 *                      Permit the users to rate the news/pair
 *
 * Created by Chang Li on 2016/2/2 0002.
 */
public class PairViewActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 2;

    private ViewPager mPager;

    private PagerAdapter mPagerAdapter;

    private Pair pair;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pairview);

        /* Receive Pair Info from the MainActivity */
        Intent intent = this.getIntent();
        this.pair = (Pair) intent.getSerializableExtra("pair");

        /* Set the Pair Title */
        TextView myTextView = (TextView) findViewById(R.id.title_text);
        myTextView.append(pair.title);

        /* Construct Fragments here */
        List<Fragment> fragments = new ArrayList<>();
        PairViewFragment newsFragment1 = new PairViewFragment();
        newsFragment1.setNews(pair.news1);
        fragments.add(newsFragment1);
        PairViewFragment newsFragment2 = new PairViewFragment();
        newsFragment2.setNews(pair.news2);
        fragments.add(newsFragment2);

        /* Init ViewPager */
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), fragments);
        mPager.setAdapter(mPagerAdapter);

        /* Setting up the Rating Pop Up Button */
        Button ratingButton = (Button) findViewById(R.id.rating_button);
        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PairViewActivity.this, RatingActivity.class));
            }
        });

        android.support.v7.app.ActionBar actionBar = super.getSupportActionBar();
        /*actionBar.setTitle(pair.title); // For some reason getSupportActionBar() keeps returning null. Will try to resolve */
    }

    public boolean onRateButtonClick(MenuItem menu) {
        startActivity(new Intent(PairViewActivity.this, RatingActivity.class));
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Inflate the menu; this adds items to the action bar if it is present */
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu_activity_pairview, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        /* Change Fragment When Slide */
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
           mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /* Fragment Adapter for the ViewPager */
    public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        /* Store Fragments */
        private List<Fragment> fragmentList;

        /* Constructor */
        public ScreenSlidePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragmentList = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
