package com.arisurya.jetpack.filmsapp.ui.movie


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
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmsRepository: FilmsRepository

    @Mock
    private lateinit var observer: Observer<List<FilmEntity>>


    @Before
    fun setUp() {
        viewModel = MoviesViewModel(filmsRepository)
    }

    @Test
    fun getMoviesDefault() {
        val dummyMovies = DataDummy.generateDummyMovies()
        val movies = MutableLiveData<List<FilmEntity>>()
        movies.postValue(dummyMovies)

        `when`(filmsRepository.getMovies()).thenReturn(movies)
        val moviesEntities = viewModel.getMoviesDefault().value
        verify(filmsRepository).getMovies()
        assertNotNull(moviesEntities)
        assertEquals(10, moviesEntities?.size)

        viewModel.getMoviesDefault().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getMoviesSortByRating() {
        val dummyMoviesSortByRating =
            DataDummy.generateDummyMovies().sortedWith(compareByDescending { it.rating })
        val movies = MutableLiveData<List<FilmEntity>>()
        movies.postValue(dummyMoviesSortByRating)

        `when`(filmsRepository.getMoviesSortedByRating()).thenReturn(movies)
        val moviesEntities = viewModel.getMoviesSortByRating().value
        verify(filmsRepository).getMoviesSortedByRating()
        assertNotNull(moviesEntities)
        assertEquals(10, moviesEntities?.size)

        if (moviesEntities != null) {
            for (i in moviesEntities.indices) {
                assertEquals(
                    dummyMoviesSortByRating[i].rating.toString(),
                    moviesEntities[i].rating.toString()
                )
            }
        }

        viewModel.getMoviesSortByRating().observeForever(observer)
        verify(observer).onChanged(dummyMoviesSortByRating)
    }

    @Test
    fun getMoviesSortByTitle() {
        val dummyMoviesSortByTitle =
            DataDummy.generateDummyMovies().sortedWith(compareBy { it.title })
        val movies = MutableLiveData<List<FilmEntity>>()
        movies.postValue(dummyMoviesSortByTitle)

        `when`(filmsRepository.getMoviesSortedByTitle()).thenReturn(movies)
        val moviesEntities = viewModel.getMoviesSortByTitle().value
        verify(filmsRepository).getMoviesSortedByTitle()
        assertNotNull(moviesEntities)
        assertEquals(10, moviesEntities?.size)

        if (moviesEntities != null) {
            for (i in moviesEntities.indices) {
                assertEquals(dummyMoviesSortByTitle[i].title, moviesEntities[i].title)
            }
        }

        viewModel.getMoviesSortByTitle().observeForever(observer)
        verify(observer).onChanged(dummyMoviesSortByTitle)
    }
}