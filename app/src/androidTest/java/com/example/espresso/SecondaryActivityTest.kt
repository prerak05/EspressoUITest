package com.example.espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondaryActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(SecondaryActivity::class.java)

    @Test
    fun testIsActivityInView() {
        onView(ViewMatchers.withId(R.id.mainSecondary)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testVisibilityTitleNextButton() {
        onView(withId(R.id.tvTitleSecondActivity)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.btnBack)).check(matches(isDisplayed()))
    }

    @Test
    fun testIsTitleTextDisplayed() {
        onView(withId(R.id.tvTitleSecondActivity)).check(matches(withText(R.string.text_secondaryactivity)))
    }
}