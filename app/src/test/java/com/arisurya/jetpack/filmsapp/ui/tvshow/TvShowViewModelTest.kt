package com.arisurya.jetpack.filmsapp.ui.tvshow

import com.arisurya.jetpack.filmsapp.data.TvShowEntity
import com.arisurya.jetpack.filmsapp.utils.DataDummy
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel
    private lateinit var dummyTvShowSortByRating: List<TvShowEntity>
    private lateinit var dummyTvShowSortByTitle: List<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
        dummyTvShowSortByRating = DataDummy.generateDummyTvShow().toMutableList().sortedWith(
            compareByDescending { it.rating })
        dummyTvShowSortByTitle =
            DataDummy.generateDummyTvShow().toMutableList().sortedWith(compareBy { it.title })
    }

    @Test
    fun getTvShowDefault() {
        val tvShowEntities = viewModel.getTvShowDefault()
        assertNotNull(tvShowEntities)
        assertEquals(11, tvShowEntities.size)
    }

    @Test
    fun getTvShowSortByRating() {
        val tvShowEntities = viewModel.getTvShowSortByRating()
        assertNotNull(tvShowEntities)
        assertEquals(11, tvShowEntities.size)
        for (i in tvShowEntities.indices) {
            assertEquals(
                dummyTvShowSortByRating[i].rating.toString(),
                tvShowEntities[i].rating.toString()
            )
        }
    }

    @Test
    fun getTvShowSortByTitle() {
        val tvShowEntities = viewModel.getTvShowSortByTitle()
        assertNotNull(tvShowEntities)
        assertEquals(11, tvShowEntities.size)
        for (i in tvShowEntities.indices) {
            assertEquals(dummyTvShowSortByTitle[i].title, tvShowEntities[i].title)
        }
    }
}