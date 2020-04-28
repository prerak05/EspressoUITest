package com.example.espresso.ui.fragment

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.espresso.R
import com.example.espresso.ui.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_movie_detail.view.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieNavigationTest {

    @Test
    fun testMovieFragmentsNavigation() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.movie_directiors)).perform(click())

        onView(withId(R.id.fragment_director)).check(matches(isDisplayed()))

        // navigate back to movie fragment
        pressBack()

        // verify movie detail fragment available
        onView(withId(R.id.fragment_movie_detail)).check(matches(isDisplayed()))

        // navigation to star cast fragment
        onView(withId(R.id.movie_star_actors)).perform(click())

        // verify movie start cast fragment available
        onView(withId(R.id.fragment_star_cast)).check(matches(isDisplayed()))

        // navigate back to movie detail
        pressBack()
    }
}