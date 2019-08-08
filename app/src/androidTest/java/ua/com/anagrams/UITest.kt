package ua.com.anagrams


import android.Manifest
import android.content.pm.ActivityInfo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Test
import ua.com.anagrams.extensions.anagrams
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.squareup.spoon.Spoon
import org.junit.Rule



class UITest {
    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)
    @get:Rule var runtimePermissionRule = GrantPermissionRule.grant(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)

    @Test
    fun correct_input() {

        onView(withId(R.id.et_anagrams_revers)).perform(typeText("add12qw2"))
        Spoon.screenshot(activityTestRule.activity, "before")
        onView(withId(R.id.ib_revers)).perform(click())
        Spoon.screenshot(activityTestRule.activity, "after")
        onView(withId(R.id.tv_anagrams_result)).check(matches(withText("add12qw2".anagrams())))
        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        onView(withId(R.id.tv_anagrams_result)).check(matches(withText("add12qw2".anagrams())))
        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        onView(withId(R.id.tv_anagrams_result)).check(matches(withText("add12qw2".anagrams())))
    }

}
