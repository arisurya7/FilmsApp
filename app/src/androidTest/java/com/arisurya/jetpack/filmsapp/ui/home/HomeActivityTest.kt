package com.arisurya.jetpack.filmsapp.ui.home


import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.arisurya.jetpack.filmsapp.R
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import com.arisurya.jetpack.filmsapp.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class HomeActivityTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                20
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.img_bg_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.img_movie_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_released)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_released)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_language)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_language)).check(matches(isDisplayed()))
        onView(withId(R.id.cd_movie)).perform(swipeUp())
        onView(withId(R.id.tv_movie_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movie_desc)).check(matches(isDisplayed()))
    }

    @Test
    fun loadVisitMovie() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.btn_visit_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_visit_movie)).perform(click())
        val device = UiDevice.getInstance(getInstrumentation())
        val currentPackage = device.currentPackageName
        assertEquals(currentPackage, "com.android.chrome")
        device.pressBack()
    }

    @Test
    fun loadShareMovie() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.btn_share)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_share)).perform(click())
    }

    @Test
    fun loadSortDefaultMovie() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)
        onView(withText(R.string.sort_by_default)).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                20
            )
        )
    }

    @Test
    fun loadSortRatingMovie() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)
        onView(withText(R.string.sort_by_rating)).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                20
            )
        )
    }

    @Test
    fun loadSortTitleMovie() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)
        onView(withText(R.string.sort_by_title)).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                20
            )
        )
    }

    @Test
    fun loadTvShows() {
        onView(withText(R.string.tv_Show)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                20
            )
        )
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText(R.string.tv_Show)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_show_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_title)).check(matches(isDisplayed()))
        onView(withId(R.id.img_bg_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.img_show_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_released)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_released)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_language)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_language)).check(matches(isDisplayed()))
        onView(withId(R.id.cd_show)).perform(swipeUp())
        onView(withId(R.id.tv_show_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_desc)).check(matches(isDisplayed()))
    }

    @Test
    fun loadSortDefaultTvShow() {
        onView(withText(R.string.tv_Show)).perform(click())
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)
        onView(withText(R.string.sort_by_default)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                20
            )
        )
    }

    @Test
    fun loadSortRatingTvShow() {
        onView(withText(R.string.tv_Show)).perform(click())
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)
        onView(withText(R.string.sort_by_rating)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                20
            )
        )
    }

    @Test
    fun loadSortTitleTvShow() {
        onView(withText(R.string.tv_Show)).perform(click())
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)
        onView(withText(R.string.sort_by_title)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                20
            )
        )
    }

}