package com.arisurya.jetpack.filmsapp.ui.favorite.favtvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteTvShowViewModelTest {

    private lateinit var viewModel: FavoriteTvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmsRepository: FilmsRepository

    @Mock
    private lateinit var observer: Observer<PagedList<FilmEntity>>

    @Mock
    private lateinit var pagedList: PagedList<FilmEntity>


    @Before
    fun setUp() {
        viewModel = FavoriteTvShowViewModel(filmsRepository)
    }

    @Test
    fun getFavoriteTvShow() {
        val dummyFavTvShow = pagedList
        Mockito.`when`(dummyFavTvShow.size).thenReturn(4)
        val tvShow = MutableLiveData<PagedList<FilmEntity>>()
        tvShow.value = dummyFavTvShow

        Mockito.`when`(filmsRepository.getFavoriteTvShows()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getFavoriteTvShow().value
        verify(filmsRepository).getFavoriteTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(4, tvShowEntities?.size)

        viewModel.getFavoriteTvShow().observeForever(observer)
        verify(observer).onChanged(dummyFavTvShow)
    }

    @Test
<<<<<<< HEAD
    fun setFavorite() {
=======
    fun setFavorite(){
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
        viewModel.setFavorite(DataDummy.generateDummyTvShow()[0])
        verify(filmsRepository).setFavoriteFilm(DataDummy.generateDummyTvShow()[0], true)
        verifyNoMoreInteractions(filmsRepository)
    }
}