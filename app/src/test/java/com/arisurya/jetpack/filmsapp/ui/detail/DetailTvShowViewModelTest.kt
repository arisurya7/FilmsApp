package com.arisurya.jetpack.filmsapp.ui.detail

import com.arisurya.jetpack.filmsapp.utils.DataDummy
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val showId = dummyTvShow.showId

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel()
        viewModel.setSelectedShow(showId)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedShow(dummyTvShow.showId)
        val tvShowEntity = viewModel.getTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.showId, tvShowEntity.showId)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.rating.toString(), tvShowEntity.rating.toString())
        assertEquals(dummyTvShow.duration, tvShowEntity.duration)
        assertEquals(dummyTvShow.released, tvShowEntity.released)
        assertEquals(dummyTvShow.language, tvShowEntity.language)
        assertEquals(dummyTvShow.description, tvShowEntity.description)
        assertEquals(dummyTvShow.imagePath, tvShowEntity.imagePath)
        assertEquals(dummyTvShow.link, tvShowEntity.link)
    }
}