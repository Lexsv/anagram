package ua.com.anagrams

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.pm.ActivityInfo
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Test
import ua.com.anagrams.extensions.anagrams
import androidx.test.rule.ActivityTestRule
import com.squareup.spoon.Spoon
import org.junit.Rule


class ExampleInstrumentedTest {
    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun correct_input() {
        onView(withId(R.id.et_anagrams_revers)).perform(typeText("add12qw2"))
        Spoon.screenshot(activityTestRule.activity, "before_click_button_revers")
        onView(withId(R.id.ib_revers)).perform(click())
        Spoon.screenshot(activityTestRule.activity, "after_click_button_revers")
        onView(withId(R.id.tv_anagrams_result)).check(matches(withText("add12qw2".anagrams())))
        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        onView(withId(R.id.tv_anagrams_result)).check(matches(withText("add12qw2".anagrams())))
        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        onView(withId(R.id.tv_anagrams_result)).check(matches(withText("add12qw2".anagrams())))
    }

}
