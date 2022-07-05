package com.arisurya.jetpack.filmsapp.ui.movie

import com.arisurya.jetpack.filmsapp.data.MovieEntity
import com.arisurya.jetpack.filmsapp.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel
    private lateinit var dummyMovieSortByRating: List<MovieEntity>
    private lateinit var dummyMovieSortByTitle: List<MovieEntity>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
        dummyMovieSortByRating = DataDummy.generateDummyMovies().toMutableList()
            .sortedWith(compareByDescending { it.rating })
        dummyMovieSortByTitle =
            DataDummy.generateDummyMovies().toMutableList().sortedWith(compareBy { it.title })
    }

    @Test
    fun getMoviesDefault() {
        val moviesEntities = viewModel.getMoviesDefault()
        assertNotNull(moviesEntities)
        assertEquals(11, moviesEntities.size)
    }

    @Test
    fun getMoviesSortByRating() {
        val moviesEntities = viewModel.getMoviesSortByRating()
        assertNotNull(moviesEntities)
        assertEquals(11, moviesEntities.size)
        for (i in moviesEntities.indices) {
            assertEquals(
                dummyMovieSortByRating[i].rating.toString(),
                moviesEntities[i].rating.toString()
            )
        }
    }

    @Test
    fun getMoviesSortByTitle() {
        val moviesEntities = viewModel.getMoviesSortByTitle()
        assertNotNull(moviesEntities)
        assertEquals(11, moviesEntities.size)
        for (i in moviesEntities.indices) {
            assertEquals(dummyMovieSortByTitle[i].title, moviesEntities[i].title)
        }
    }
}