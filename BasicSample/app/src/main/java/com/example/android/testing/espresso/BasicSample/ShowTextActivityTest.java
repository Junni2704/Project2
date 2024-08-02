package com.example.android.testing.espresso.BasicSample;

import android.content.Intent;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ShowTextActivityTest {

    @Test
    public void testShowTextActivity_EmptyInput() {
        Intent intent = ShowTextActivity.newStartIntent(ApplicationProvider.getApplicationContext(), "");
        ActivityScenario.launch(intent);
        onView(withId(R.id.show_text_view)).check(matches(withText("")));
    }

    @Test
    public void testShowTextActivity_NumericInput() {
        Intent intent = ShowTextActivity.newStartIntent(ApplicationProvider.getApplicationContext(), "123");
        ActivityScenario.launch(intent);
        onView(withId(R.id.show_text_view)).check(matches(withText("123")));
    }

}