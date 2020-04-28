package com.example.espresso

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    @Test
    fun testIsActivityInView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun testVisibilityTitleNextButton() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.tvTitleMainActivity)).check(matches(isDisplayed()))
        onView(withId(R.id.btnNext)).check(matches(isDisplayed()))
//        onView(withId(R.id.btnNext)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

    }

    @Test
    fun testIsTitleTextDisplayed() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.tvTitleMainActivity)).check(matches(withText(R.string.text_mainactivity)))
    }

    @Test
    fun testNavSecondaryActivity() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.btnNext)).perform(ViewActions.click())
        onView(withId(R.id.mainSecondary)).check(matches(isDisplayed()))

    }


//    @Test
//    fun testBackPressToMainActivity() {
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
//        onView(withId(R.id.btnNext)).perform(ViewActions.click())
//        onView(withId(R.id.mainSecondary)).check(matches(isDisplayed()))
//        pressBack()
//        onView(withId(R.id.main)).check(matches(isDisplayed()))
//    }
}