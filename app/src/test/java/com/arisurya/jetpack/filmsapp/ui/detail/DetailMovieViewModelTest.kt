package com.arisurya.jetpack.filmsapp.ui.detail


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.DataSource
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.utils.DataDummy
import com.arisurya.jetpack.filmsapp.vo.Resource
import com.nhaarman.mockitokotlin2.*
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
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
        val movieEntity = viewModel.getMovieDetail()
        assertNotNull(movieEntity)
        viewModel.detailMovie.observeForever(observer)
        verify(observer).onChanged(dummyDetailMovie)
    }

    @Test
    fun setMovieFavorite(){
        viewModel.setMovieFavorite(DataDummy.generateDummyMovies()[0])
        verify(filmsRepository).setFavoriteFilm(DataDummy.generateDummyMovies()[0], true)
        verifyNoMoreInteractions(filmsRepository)
    }
}