package au.com.fairfaxmedia.newsapp

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.scrollTo
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import au.com.fairfaxmedia.newsapp.view.activity.MainActivity
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import au.com.fairfaxmedia.newsapp.view.adapter.NewsListViewHolder
import kotlinx.android.synthetic.main.fragment_listview.*
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Assert
import org.junit.Rule



/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule @JvmField
    var mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("au.com.fairfaxmedia.newsapp", appContext.packageName)
    }


    @Test
    fun navigateToArticleDetails() {
        //Find the first cell in recycle view and tap on it to go to article detail screen
       onView(withId(R.id.recycler_view))
               .perform(RecyclerViewActions.actionOnItemAtPosition<NewsListViewHolder>(0,click()))

        //Assert that web view exist on article detail screen
        onView(withId(R.id.webview)).check(matches(isDisplayed()))

    }

    //This test checks that fields representing headline, thumbnail, abstract and by line exist for the first news item
    //As the view is same for each news story, no need to check this for each news item
    @Test
    fun verifyFieldsExist() {
         //Find the first news item using id=0 (this was set in NewsListViewHolder.
         //Then, check its got 4 children each with specific ids
         onView(withId(0))
                .check(matches(hasChildCount(4)))
                .check(matches(hasDescendant(withId(R.id.headline))))
                .check(matches(hasDescendant(withId(R.id.thumbnail))))
                .check(matches(hasDescendant(withId(R.id.theAbstract))))
                .check(matches(hasDescendant(withId(R.id.byLine))))
    }

    @Test
    fun verifyOnly10ItemsInRecycleView() {

        //Check that total item in the news adapter is not more than 10
        Assert.assertTrue(mActivityRule.activity.recycler_view.adapter.itemCount<=10)
        //Now, check that every news item is displayed on the view
        var newsIndex = 0
        do{
            onView(withId(R.id.recycler_view))
                    .perform(RecyclerViewActions.scrollToPosition<NewsListViewHolder>(newsIndex))
                    .check(matches(isDisplayed()))
            newsIndex+=1
        }while(newsIndex<=mActivityRule.activity.recycler_view.adapter.itemCount)

    }


}
