package com.arisurya.jetpack.filmsapp.ui.tvshow

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
class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmsRepository: FilmsRepository

    @Mock
    private lateinit var observer: Observer<List<FilmEntity>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(filmsRepository)
    }

    @Test
    fun getTvShowDefault() {
        val dummyTvShow = DataDummy.generateDummyTvShow()
        val tvShow = MutableLiveData<List<FilmEntity>>()
        tvShow.postValue(dummyTvShow)

        `when`(filmsRepository.getTvShows()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getTvShowDefault().value
        verify(filmsRepository).getTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getTvShowDefault().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }

    @Test
    fun getTvShowSortByRating() {
        val dummyTvShowSortByRating =
            DataDummy.generateDummyTvShow().sortedWith(compareByDescending { it.rating })
        val tvShow = MutableLiveData<List<FilmEntity>>()
        tvShow.postValue(dummyTvShowSortByRating)

        `when`(filmsRepository.getTvShowsSortedByRating()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getTvShowSortByRating().value
        verify(filmsRepository).getTvShowsSortedByRating()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        if (tvShowEntities != null) {
            for (i in tvShowEntities.indices) {
                assertEquals(
                    dummyTvShowSortByRating[i].rating.toString(),
                    tvShowEntities[i].rating.toString()
                )
            }
        }

        viewModel.getTvShowSortByRating().observeForever(observer)
        verify(observer).onChanged(dummyTvShowSortByRating)
    }

    @Test
    fun getTvShowSortByTitle() {

        val dummyTvShowSortByTitle =
            DataDummy.generateDummyTvShow().sortedWith(compareBy { it.rating })
        val tvShow = MutableLiveData<List<FilmEntity>>()
        tvShow.postValue(dummyTvShowSortByTitle)

        `when`(filmsRepository.getTvShowsSortedByTitle()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getTvShowSortByTitle().value
        verify(filmsRepository).getTvShowsSortedByTitle()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        if (tvShowEntities != null) {
            for (i in tvShowEntities.indices) {
                assertEquals(
                    dummyTvShowSortByTitle[i].rating.toString(),
                    tvShowEntities[i].rating.toString()
                )
            }
        }

        viewModel.getTvShowSortByTitle().observeForever(observer)
        verify(observer).onChanged(dummyTvShowSortByTitle)
    }
}