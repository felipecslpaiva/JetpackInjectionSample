package gg.paiva.jetpackexploration.fragments

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import gg.paiva.jetpackexploration.MainActivity
import gg.paiva.jetpackexploration.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FirstFragmentTestSuite {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkTextDisplayedInDynamicallyCreatedFragment() {
        onView(withId(R.id.textview_first)).check(matches(withText(R.string.hello_first_fragment)))
    }

    @Test
    fun testClickActionbarItem() {
        openActionBarOverflowOrOptionsMenu(activityRule.activity)
        onView(withText(R.string.action_settings)).check(matches(isDisplayed()))
        onView(withText(R.string.action_settings)).perform(click())
    }
}