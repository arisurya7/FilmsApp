package com.arisurya.jetpack.filmsapp.ui.detail


import com.arisurya.jetpack.filmsapp.utils.DataDummy
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(movieId)
    }


    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.rating.toString(), movieEntity.rating.toString())
        assertEquals(dummyMovie.duration, movieEntity.duration)
        assertEquals(dummyMovie.released, movieEntity.released)
        assertEquals(dummyMovie.language, movieEntity.language)
        assertEquals(dummyMovie.description, movieEntity.description)
        assertEquals(dummyMovie.imagePath, movieEntity.imagePath)
        assertEquals(dummyMovie.link, movieEntity.link)
    }
}