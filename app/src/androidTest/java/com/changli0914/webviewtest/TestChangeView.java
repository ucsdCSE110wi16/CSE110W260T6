package com.changli0914.webviewtest;

import android.test.ActivityInstrumentationTestCase2;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.test.ActivityInstrumentationTestCase2;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.atomic.AtomicReference;

import static android.support.test.espresso.Espresso.onView;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by ronan on 12/03/2016.
 */
public class TestChangeView
    extends ActivityInstrumentationTestCase2<MainActivity>
    {

        private MainActivity activity;
        public TestChangeView() {
        super(MainActivity.class);

    }

        @Override
        public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

        public void testClick() {
            onView(withId(R.id.button_add)).perform(click());
            onView(withId(R.id.add_pair_text1)).check(matches(withText("Pair Title")));

        }
}
