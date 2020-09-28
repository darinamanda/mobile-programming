package id.ac.ui.cs.mobileprogramming.darinamanda.helloworld

import androidx.test.espresso.Espresso.onView
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
class MainActivityInstrumentedTestInstrumentedTest {
    private lateinit var storyText: String

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        storyText = "Bagaimana perasaanmu hari ini?"
    }

    @Test
    fun testMainIsDisplayed() {
        onView(withId(R.id.main_page)).check(matches(isDisplayed()))
        onView(withId(R.id.main_page)).check(matches(Matchers.notNullValue()))
    }

    @Test
    fun testImageIsDisplayed() {
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        onView(withId(R.id.imageView)).check(matches(Matchers.notNullValue()))
    }

    @Test
    fun testFormIsDisplayed() {
        onView(withId(R.id.storyForm)).check(matches(isDisplayed()))
        onView(withId(R.id.storyForm)).check(matches(Matchers.notNullValue()))
    }

    @Test
    fun testFormTextContent() {
        onView(withId(R.id.storyForm)).check(matches(withHint(storyText)))
    }

    @Test
    fun testButtonIsDisplayed() {
        onView(withId(R.id.storyButton)).check(matches(isDisplayed()))
        onView(withId(R.id.storyButton)).check(matches(Matchers.notNullValue()))
    }

    @Test
    fun testSendButtonClickable() {
        onView(withId(R.id.storyButton)).check(matches(isClickable()))
    }
}