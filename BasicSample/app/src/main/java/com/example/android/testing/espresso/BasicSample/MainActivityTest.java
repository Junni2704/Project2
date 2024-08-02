package com.example.android.testing.espresso.BasicSample;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.intent.Intents;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testChangeTextButton_EmptyInput() {
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged)).check(matches(withText("")));
    }

    @Test
    public void testOpenActivityButton_EmptyInput() {
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        intended(hasComponent(ShowTextActivity.class.getName()));
        intended(hasExtra(ShowTextActivity.KEY_EXTRA_MESSAGE, ""));
    }

    @Test
    public void testChangeTextButton_NumericInput() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("123"));
        closeSoftKeyboard();
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged)).check(matches(withText("123")));
    }

    @Test
    public void testOpenActivityButton_NumericInput() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("123"));
        closeSoftKeyboard();
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        intended(hasComponent(ShowTextActivity.class.getName()));
        intended(hasExtra(ShowTextActivity.KEY_EXTRA_MESSAGE, "123"));
    }

    @Test
    public void testChangeTextButton_AlphabeticInput() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"));
        closeSoftKeyboard();
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged)).check(matches(withText("abcdef")));
    }

    @Test
    public void testOpenActivityButton_AlphabeticInput() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"));
        closeSoftKeyboard();
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        intended(hasComponent(ShowTextActivity.class.getName()));
        intended(hasExtra(ShowTextActivity.KEY_EXTRA_MESSAGE, "abcdef"));
    }
}