package se.zeb.minnatv

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.test.InstrumentationTestCase
import com.squareup.okhttp.mockwebserver.MockResponse
import com.squareup.okhttp.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Forza Football
 * <p>
 * Created by Sebastian Fürle on 2018-01-14
 * <p>
 * Copyright © 2018 FootballAddicts. All rights reserved.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest : InstrumentationTestCase() {

    @Rule
    var mActivityRule = ActivityTestRule(MainActivity::class.java, true, false)
    private var server: MockWebServer? = null

    @Before
    @Throws(Exception::class)
    override fun setUp() {
        super.setUp()
        server = MockWebServer()
        server!!.start()
        injectInstrumentation(InstrumentationRegistry.getInstrumentation())
        Constants.BASE_URL = server!!.url("/").toString()
    }

   /* @Test
    @Throws(Exception::class)
    fun testQuoteIsShown() {
        val fileName = "quote_200_ok_response.json"
        server!!.enqueue(MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().context, fileName)))

        val intent = Intent()
        mActivityRule.launchActivity(intent)

        onView(withId(R.id.button_retry)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
        onView(withText("I came from a real tough neighborhood. Once a guy pulled a knife on me. I knew he wasn't a professional, the knife had butter on it.")).check(matches(isDisplayed()))
    }


    @Test
    @Throws(Exception::class)
    fun testRetryButtonShowsWhenError() {
        val fileName = "quote_404_not_found.json"

        server!!.enqueue(MockResponse()
                .setResponseCode(404)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().context, fileName)))

        val intent = Intent()
        mActivityRule.launchActivity(intent)

        onView(withId(R.id.button_retry)).check(matches(isDisplayed()))
        onView(withText("Quote Not found")).check(matches(isDisplayed()))
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        server!!.shutdown()
    }*/
}
