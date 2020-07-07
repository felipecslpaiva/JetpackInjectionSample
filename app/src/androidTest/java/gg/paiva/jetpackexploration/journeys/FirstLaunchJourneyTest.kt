package gg.paiva.jetpackexploration.journeys

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import gg.paiva.jetpackexploration.MainActivity
import gg.paiva.jetpackexploration.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class FirstLaunchJourneyTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    //This is a sample of automation test for a user journey
    @Test
    fun firstJourney() {
        //Check if the fragment is visible
        onView(withId(R.id.nav_host_fragment)).check(matches(isDisplayed()))

        //CHeck if the button has the expected text on it
        onView(withId(R.id.button_first)).check(matches(ViewMatchers.withText(R.string.next)))

        //Click on button
        onView(withId(R.id.button_first)).perform(click())

        //Check if the textview from the second fragment is displayed
        onView(withId(R.id.textview_second)).check(matches(withText(R.string.hello_second_fragment)))
    }
}