package com.arisurya.jetpack.filmsapp.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val showId = dummyTvShow.filmId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmsRepository: FilmsRepository

    @Mock
    private lateinit var observer: Observer<FilmEntity>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(filmsRepository)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedShow(showId)
        val tvShow = MutableLiveData<FilmEntity>()
        tvShow.postValue(dummyTvShow)

        `when`(filmsRepository.getDetailTvShow(showId.toInt())).thenReturn(tvShow)
        val tvShowEntity = viewModel.getTvShow().value as FilmEntity

        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.filmId, tvShowEntity.filmId)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.rating.toString(), tvShowEntity.rating.toString())
        assertEquals(dummyTvShow.duration, tvShowEntity.duration)
        assertEquals(dummyTvShow.released, tvShowEntity.released)
        assertEquals(dummyTvShow.language, tvShowEntity.language)
        assertEquals(dummyTvShow.description, tvShowEntity.description)
        assertEquals(dummyTvShow.imagePath, tvShowEntity.imagePath)
        assertEquals(dummyTvShow.link, tvShowEntity.link)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}