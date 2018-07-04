package au.com.fairfaxmedia.newsapp

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.doesNotExist
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import au.com.fairfaxmedia.newsapp.view.activity.MainActivity
import android.support.test.rule.ActivityTestRule
import au.com.fairfaxmedia.newsapp.view.adapter.NewsListViewHolder
import kotlinx.android.synthetic.main.fragment_listview.*
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

    //This test clicks on the first news item and navigate to article details screen
    //There it verifies that web view is present
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
        //Find the news item using id (this was set in NewsListViewHolder).
        //Then, check its got 4 children each with specific ids

        val totalCount = mActivityRule.activity.recycler_view.adapter.itemCount-1
        for (i in 0..totalCount)
        {
            onView(withId(R.id.recycler_view))
                    .perform(RecyclerViewActions.scrollToPosition<NewsListViewHolder>(i))

            onView(withId(i))
                    .check(matches(hasChildCount(4)))
                    .check(matches(hasDescendant(withId(R.id.headline))))
                    .check(matches(hasDescendant(withId(R.id.thumbnail))))
                    .check(matches(hasDescendant(withId(R.id.theAbstract))))
                    .check(matches(hasDescendant(withId(R.id.byLine))))
        }
    }

    @Test
    fun verifyOnly10ItemsInRecycleView() {

        //Check that total item in the news adapter is not more than 10
        Assert.assertTrue(mActivityRule.activity.recycler_view.adapter.itemCount<=10)
        //Now, check that every news item is displayed on the view
        val totalCount = mActivityRule.activity.recycler_view.adapter.itemCount-1
        for (i in 0..totalCount)
        {
            onView(withId(R.id.recycler_view))
                    .perform(RecyclerViewActions.scrollToPosition<NewsListViewHolder>(i))

            onView(withId(i))
                    .check(matches(isDisplayed()))

        }

        //Verify that count+1 item doesn't exist
        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.scrollToPosition<NewsListViewHolder>(totalCount+1))

        onView(withId(totalCount+1))
                .check(doesNotExist())
    }


}
