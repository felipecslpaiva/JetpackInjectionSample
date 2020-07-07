package gg.paiva.jetpackexploration.mainActivity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
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
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java,
        true,
        false)

    @Test
    fun listGoesOverTheFold() {
        onView(ViewMatchers.withId(R.id.nav_host_fragment)).check(matches(isDisplayed()))
    }
}