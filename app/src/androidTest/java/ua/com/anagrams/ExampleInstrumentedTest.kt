package ua.com.anagrams

import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Test
import ua.com.anagrams.extensions.anagrams
import androidx.test.rule.ActivityTestRule
import org.junit.Rule


class ExampleInstrumentedTest {
    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun correct_input() {
        onView(withId(R.id.et_anagrams_revers)).perform(typeText("add12qw2"))
        onView(withId(R.id.ib_revers)).perform(click())
        onView(withId(R.id.tv_anagrams_result)).check(matches(withText("add12qw2".anagrams())))
        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        onView(withId(R.id.tv_anagrams_result)).check(matches(withText("add12qw2".anagrams())))
        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        onView(withId(R.id.tv_anagrams_result)).check(matches(withText("add12qw2".anagrams())))
    }


}
