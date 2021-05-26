package com.arisurya.jetpack.filmsapp.ui.movie


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
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

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
        viewModel = MoviesViewModel(filmsRepository)
    }

    @Test
    fun getMoviesDefault() {
        val dummyMovies = Resource.success(pagedList)
        `when`(dummyMovies.data?.size).thenReturn(4)
        val movies = MutableLiveData<Resource<PagedList<FilmEntity>>>()
        movies.value = dummyMovies

        `when`(filmsRepository.getMovies()).thenReturn(movies)
        val moviesEntities = viewModel.getMoviesDefault().value?.data
        verify(filmsRepository).getMovies()
        assertNotNull(moviesEntities)
        assertEquals(4, moviesEntities?.size)

        viewModel.getMoviesDefault().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getMoviesSortByRating() {
        val dummyMoviesSortByRating = Resource.success(
            PagedListUtils.mockPagedList(
                DataDummy.generateDummyMovies().sortedWith(compareByDescending { it.rating })
            )
        )
        `when`(dummyMoviesSortByRating.data?.size).thenReturn(4)
        val movies = MutableLiveData<Resource<PagedList<FilmEntity>>>()
        movies.value = dummyMoviesSortByRating

        `when`(filmsRepository.getMoviesSortedByRating()).thenReturn(movies)
        val moviesEntities = viewModel.getMoviesSortByRating().value?.data
        verify(filmsRepository).getMoviesSortedByRating()
        assertNotNull(moviesEntities)
        assertEquals(4, moviesEntities?.size)

        if (moviesEntities != null) {
            for (i in moviesEntities.indices) {
                assertEquals(
                    dummyMoviesSortByRating.data?.get(i)?.rating.toString(),
                    moviesEntities[i]?.rating.toString()
                )
            }
        }

        viewModel.getMoviesSortByRating().observeForever(observer)
        verify(observer).onChanged(dummyMoviesSortByRating)
    }

    @Test
    fun getMoviesSortByTitle() {
        val dummyMoviesSortByTitle = Resource.success(
            PagedListUtils.mockPagedList(
                DataDummy.generateDummyMovies().sortedWith(compareBy { it.title })
            )
        )
        `when`(dummyMoviesSortByTitle.data?.size).thenReturn(4)
        val movies = MutableLiveData<Resource<PagedList<FilmEntity>>>()
        movies.value = dummyMoviesSortByTitle

        `when`(filmsRepository.getMoviesSortedByRating()).thenReturn(movies)
        val moviesEntities = viewModel.getMoviesSortByRating().value?.data
        verify(filmsRepository).getMoviesSortedByRating()
        assertNotNull(moviesEntities)
        assertEquals(4, moviesEntities?.size)

        if (moviesEntities != null) {
            for (i in moviesEntities.indices) {
                assertEquals(
                    dummyMoviesSortByTitle.data?.get(i)?.title.toString(),
                    moviesEntities[i]?.title.toString()
                )
            }
        }

        viewModel.getMoviesSortByRating().observeForever(observer)
        verify(observer).onChanged(dummyMoviesSortByTitle)
    }
}