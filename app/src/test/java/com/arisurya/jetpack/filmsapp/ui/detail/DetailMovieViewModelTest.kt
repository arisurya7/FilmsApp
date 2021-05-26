package com.arisurya.jetpack.filmsapp.ui.detail


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.utils.DataDummy
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
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.filmId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmsRepository: FilmsRepository

    @Mock
    private lateinit var observer: Observer<Resource<FilmEntity>>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(filmsRepository)
    }


    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(movieId)
        val dummyDetailMovie = Resource.success(DataDummy.generateDummyMovies()[0])
        val movie = MutableLiveData<Resource<FilmEntity>>()
        movie.value = dummyDetailMovie

        `when`(filmsRepository.getDetailMovie(movieId.toInt())).thenReturn(movie)
        val movieEntity = viewModel.getMovie().value?.data
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.filmId, movieEntity?.filmId)
        assertEquals(dummyMovie.title, movieEntity?.title)
        assertEquals(dummyMovie.rating.toString(), movieEntity?.rating.toString())
        assertEquals(dummyMovie.duration, movieEntity?.duration)
        assertEquals(dummyMovie.released, movieEntity?.released)
        assertEquals(dummyMovie.language, movieEntity?.language)
        assertEquals(dummyMovie.description, movieEntity?.description)
        assertEquals(dummyMovie.imagePath, movieEntity?.imagePath)
        assertEquals(dummyMovie.link, movieEntity?.link)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyDetailMovie)
    }
}