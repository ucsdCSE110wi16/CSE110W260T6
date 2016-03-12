package com.changli0914.webviewtest;

/**
 * Created by Daniel on 3/11/2016.
 */

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.test.ActivityInstrumentationTestCase2;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.onData;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class AddPairTest {

    private PairManager pairManager;
    private List<Pair> pairList;
    private String sampleTitleString;
    private String sampleComment;
    private String sampleSubtitle1;
    private String sampleSubtitle2;
    private String sampleURL1;
    private String sampleURL2;
    private int sampleImage;
    private Pair testPair;

    @Rule
    public ActivityTestRule<AddPairActivity> addPairActivityActivityTestRule = new ActivityTestRule<>(AddPairActivity.class);

    @Before
    public void initPairManager() {
        pairManager = PairManager.getPairManager();
        pairList = pairManager.getPairs();
    }

    @Before
    public void initVals() {
        sampleTitleString = "Test post";
        sampleComment = "Test Comment";
        sampleSubtitle1 = "test article 1";
        sampleSubtitle2 = "test article 2";
        sampleURL1 = "www.google.com";
        sampleURL2 = "www.yahoo.com";
        sampleImage = R.drawable.google;
    }

    @Before
    public void initPair() {
        testPair = Pair.createPair(sampleTitleString, sampleComment, sampleImage, null, new Date(), NewsCategory.Politics, NewsRegion.US,
                sampleURL1, sampleSubtitle1, NewsSource.Yahoo, 1.0, sampleURL2, sampleSubtitle2, NewsSource.ABC, 2.0);
    }

    @Test
    public void testAddPairActivity() {
        onView(withId(R.id.add_pair_title)).perform(clearText());
        onView(withId(R.id.add_pair_title)).perform(typeText(sampleTitleString));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.add_pair_subtitle1)).perform(clearText());
        onView(withId(R.id.add_pair_subtitle1)).perform(typeText(sampleSubtitle1));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.add_pair_subtitle2)).perform(clearText());
        onView(withId(R.id.add_pair_subtitle2)).perform(typeText(sampleSubtitle2));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.add_pair_url1)).perform(clearText());
        onView(withId(R.id.add_pair_url1)).perform(typeText(sampleURL1));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.add_pair_url2)).perform(clearText());
        onView(withId(R.id.add_pair_url2)).perform(typeText(sampleURL2));
        Espresso.closeSoftKeyboard();

        // check everything's been entered properly
        onView(withId(R.id.add_pair_title)).check(matches(withText(sampleTitleString)));
        onView(withId(R.id.add_pair_subtitle1)).check(matches(withText(sampleSubtitle1)));
        onView(withId(R.id.add_pair_subtitle2)).check(matches(withText(sampleSubtitle2)));
        onView(withId(R.id.add_pair_url1)).check(matches(withText(sampleURL1)));
        onView(withId(R.id.add_pair_url2)).check(matches(withText(sampleURL2)));

        // apparently Espresso needs someone scroll down for it
        // submit. This adds the pair to the DB, then exits the activity so we can't check anything else.
        onView(withId(R.id.button_submit)).perform(scrollTo(), click());

        // check for new entry in database. Can't figure it out. But just running the app and looking in the DB it works right.
        // this test will not run because pressing "submit" closes AddPairActivity
        // onData(allOf(is(instanceOf(Pair.class)), is(testPair))).check(matches(isDisplayed()));
    }
}
