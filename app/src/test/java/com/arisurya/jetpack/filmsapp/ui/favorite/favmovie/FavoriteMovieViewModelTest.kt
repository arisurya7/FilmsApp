package com.arisurya.jetpack.filmsapp.ui.favorite.favmovie

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
class FavoriteMovieViewModelTest {

    private lateinit var viewModel: FavoriteMovieViewModel

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
        viewModel = FavoriteMovieViewModel(filmsRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyFavMovies = pagedList
        Mockito.`when`(dummyFavMovies.size).thenReturn(4)
        val movies = MutableLiveData<PagedList<FilmEntity>>()
        movies.value = dummyFavMovies

        Mockito.`when`(filmsRepository.getFavoriteMovies()).thenReturn(movies)
        val moviesEntities = viewModel.getFavoriteMovies().value
        verify(filmsRepository).getFavoriteMovies()
        assertNotNull(moviesEntities)
        assertEquals(4, moviesEntities?.size)

        viewModel.getFavoriteMovies().observeForever(observer)
        verify(observer).onChanged(dummyFavMovies)
    }

    @Test
    fun setFavorite(){
        viewModel.setFavorite(DataDummy.generateDummyMovies()[0])
        verify(filmsRepository).setFavoriteFilm(DataDummy.generateDummyMovies()[0], true)
        verifyNoMoreInteractions(filmsRepository)
    }
}