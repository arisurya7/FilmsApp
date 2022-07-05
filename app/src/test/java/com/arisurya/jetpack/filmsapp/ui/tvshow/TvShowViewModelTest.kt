package com.arisurya.jetpack.filmsapp.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.utils.DataDummy
import com.arisurya.jetpack.filmsapp.utils.PagedListUtils
import com.arisurya.jetpack.filmsapp.vo.Resource
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
    private lateinit var observer: Observer<Resource<PagedList<FilmEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<FilmEntity>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(filmsRepository)
    }

    @Test
    fun getTvShowDefault() {
        val dummyTvShow = Resource.success(pagedList)
        `when`(dummyTvShow.data?.size).thenReturn(4)
        val tvShow = MutableLiveData<Resource<PagedList<FilmEntity>>>()
        tvShow.value = dummyTvShow

        `when`(filmsRepository.getTvShows()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getTvShowDefault().value?.data
        verify(filmsRepository).getTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(4, tvShowEntities?.size)

        viewModel.getTvShowDefault().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }

    @Test
    fun getTvShowSortByRating() {
        val dummyTvShowSortByRating = Resource.success(
            PagedListUtils.mockPagedList(
                DataDummy.generateDummyTvShow().sortedWith(compareByDescending { it.rating })
            )
        )
        `when`(dummyTvShowSortByRating.data?.size).thenReturn(4)
        val tvShow = MutableLiveData<Resource<PagedList<FilmEntity>>>()
        tvShow.value = dummyTvShowSortByRating

        `when`(filmsRepository.getTvShowsSortedByRating()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getTvShowSortByRating().value?.data
        verify(filmsRepository).getTvShowsSortedByRating()
        assertNotNull(tvShowEntities)
        assertEquals(4, tvShowEntities?.size)

        if (tvShowEntities != null) {
            for (i in tvShowEntities.indices) {
                assertEquals(
                    dummyTvShowSortByRating.data?.get(i)?.rating.toString(),
                    tvShowEntities[i]?.rating.toString()
                )
            }
        }

        viewModel.getTvShowSortByRating().observeForever(observer)
        verify(observer).onChanged(dummyTvShowSortByRating)
    }

    @Test
    fun getTvShowSortByTitle() {
        val dummyTvShowSortByTitle = Resource.success(
            PagedListUtils.mockPagedList(
                DataDummy.generateDummyTvShow().sortedWith(compareByDescending { it.title })
            )
        )
        `when`(dummyTvShowSortByTitle.data?.size).thenReturn(4)
        val tvShow = MutableLiveData<Resource<PagedList<FilmEntity>>>()
        tvShow.value = dummyTvShowSortByTitle

        `when`(filmsRepository.getTvShowsSortedByTitle()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getTvShowSortByTitle().value?.data
        verify(filmsRepository).getTvShowsSortedByTitle()
        assertNotNull(tvShowEntities)
        assertEquals(4, tvShowEntities?.size)

        if (tvShowEntities != null) {
            for (i in tvShowEntities.indices) {
                assertEquals(
                    dummyTvShowSortByTitle.data?.get(i)?.title.toString(),
                    tvShowEntities[i]?.title.toString()
                )
            }
        }

        viewModel.getTvShowSortByTitle().observeForever(observer)
        verify(observer).onChanged(dummyTvShowSortByTitle)
    }
}