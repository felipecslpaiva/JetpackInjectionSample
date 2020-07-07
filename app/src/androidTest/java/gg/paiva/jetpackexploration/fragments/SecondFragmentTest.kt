package gg.paiva.jetpackexploration.fragments

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import gg.paiva.jetpackexploration.MainActivity
import gg.paiva.jetpackexploration.R
import gg.paiva.jetpackexploration.SecondFragment
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SecondFragmentTestSuite {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkTextEmptyDisplayedInDynamicallyCreatedFragment() {
        val fragment = SecondFragment()
        activityRule.activity.supportFragmentManager.beginTransaction()
            .add(R.id.nav_host_fragment, fragment).commit()
        onView(withId(R.id.textview_second)).check(matches(withText(R.string.hello_second_fragment)))
    }
}