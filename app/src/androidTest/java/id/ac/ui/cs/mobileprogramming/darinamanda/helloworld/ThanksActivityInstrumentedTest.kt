package id.ac.ui.cs.mobileprogramming.darinamanda.helloworld

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ThanksActivityInstrumentedTest {
    private lateinit var showedText: String
    private lateinit var popUpText: String

    @get:Rule
    var activityRule: ActivityScenarioRule<ThanksActivity> = ActivityScenarioRule(ThanksActivity::class.java)

    @Before
    fun setUp() {
        popUpText = "Terima kasih karena sudah berjuang sampai hari ini"
    }

    @Test
    fun testPageIsDisplayed() {
        onView(withId(R.id.thanks_page)).check(matches(isDisplayed()))
        onView(withId(R.id.thanks_page)).check(matches(Matchers.notNullValue()))
    }

    @Test
    fun testImageIsDisplayed() {
        onView(withId(R.id.imageView2)).check(matches(isDisplayed()))
        onView(withId(R.id.imageView2)).check(matches(Matchers.notNullValue()))
    }

    @Test
    fun testFirstTextContent() {
        onView(withId(R.id.thanksText)).check(matches(withText(showedText)))
    }


    @Test
    fun testButtonIsDisplayed() {
        onView(withId(R.id.thanksButton)).check(matches(isDisplayed()))
        onView(withId(R.id.thanksButton)).check(matches(Matchers.notNullValue()))
    }

    @Test
    fun testThanksButtonClickable() {
        onView(withId(R.id.thanksButton)).check(matches(isClickable()))
    }

    @Test
    fun testThanksButtonFunctionality() {
        onView(withId(R.id.thanksButton)).perform(click())
        onView(withId(R.id.thanksText)).check(matches(withText(popUpText)))
    }
}