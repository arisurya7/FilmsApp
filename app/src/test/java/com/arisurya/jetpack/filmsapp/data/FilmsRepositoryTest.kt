package com.arisurya.jetpack.filmsapp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.arisurya.jetpack.filmsapp.data.source.local.LocalDataSource
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.data.source.remote.RemoteDataSource
import com.arisurya.jetpack.filmsapp.utils.AppExecutors
import com.arisurya.jetpack.filmsapp.utils.DataDummy
import com.arisurya.jetpack.filmsapp.utils.LiveDataTestUtil
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import com.nhaarman.mockitokotlin2.verify
import org.mockito.Mockito.*
import androidx.paging.DataSource
import com.arisurya.jetpack.filmsapp.utils.PagedListUtils
import com.arisurya.jetpack.filmsapp.vo.Resource

@Suppress("UNCHECKED_CAST")
class FilmsRepositoryTest {

    @get: Rule
    var instanceTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val filmsRepository = FakeFilmsRepository(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponse[0].id
    private val tvShowResponse = DataDummy.generateRemoteDummyTvShow()
    private val tvShowId = tvShowResponse[0].id
    private val detailMovieResponse = DataDummy.generateRemoteDummyDetailMovie()
    private val detailTvShowResponse = DataDummy.generateRemoteDummyDetailTvShow()

    @Test
    fun getMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FilmEntity>
        `when`(local.getMovies()).thenReturn(dataSourceFactory)
        filmsRepository.getMovies()

        val movieEntities =
            Resource.success(PagedListUtils.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getMoviesSortedByRating() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FilmEntity>
        `when`(local.getMoviesSortByRating()).thenReturn(dataSourceFactory)
        filmsRepository.getMoviesSortedByRating()

        val movieEntities = Resource.success(
            PagedListUtils.mockPagedList(
                DataDummy.generateDummyMovies().sortedWith(compareByDescending { it.rating })
            )
        )
        verify(local).getMoviesSortByRating()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getMoviesSortedByTitle() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FilmEntity>
        `when`(local.getMoviesSortByTitle()).thenReturn(dataSourceFactory)
        filmsRepository.getMoviesSortedByTitle()

        val movieEntities = Resource.success(
            PagedListUtils.mockPagedList(
                DataDummy.generateDummyMovies().sortedWith(compareBy { it.title })
            )
        )
        verify(local).getMoviesSortByTitle()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummyMovie = MutableLiveData<FilmEntity>()
        dummyMovie.value = DataDummy.generateDummyMovies()[0]
        `when`(local.getDetailFilm(movieId.toString())).thenReturn(dummyMovie)

        val movieEntity = LiveDataTestUtil.getValue(filmsRepository.getDetailMovie(movieId))
        verify(local).getDetailFilm(movieId.toString())
        assertNotNull(movieEntity)
        assertEquals(detailMovieResponse.id.toString(), movieEntity.data?.filmId)
    }

    @Test
    fun getTvShows() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FilmEntity>
        `when`(local.getTvShows()).thenReturn(dataSourceFactory)
        filmsRepository.getTvShows()

        val tvShowEntities =
            Resource.success(PagedListUtils.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(movieResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShowsSortedByRating() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FilmEntity>
        `when`(local.getTvShowSortByRating()).thenReturn(dataSourceFactory)
        filmsRepository.getTvShowsSortedByRating()

        val tvShowEntities = Resource.success(
            PagedListUtils.mockPagedList(
                DataDummy.generateDummyTvShow().sortedWith(compareByDescending { it.rating })
            )
        )
        verify(local).getTvShowSortByRating()
        assertNotNull(tvShowEntities)
        assertEquals(movieResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShowsSortedByTitle() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FilmEntity>
        `when`(local.getTvShowSortByTitle()).thenReturn(dataSourceFactory)
        filmsRepository.getTvShowsSortedByTitle()

        val tvShowEntities = Resource.success(
            PagedListUtils.mockPagedList(
                DataDummy.generateDummyTvShow().sortedWith(compareBy { it.title })
            )
        )
        verify(local).getTvShowSortByTitle()
        assertNotNull(tvShowEntities)
        assertEquals(movieResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailTvShow() {
        val dummyTvShow = MutableLiveData<FilmEntity>()
        dummyTvShow.value = DataDummy.generateDummyTvShow()[0]
        `when`(local.getDetailFilm(tvShowId.toString())).thenReturn(dummyTvShow)

        val tvShowEntity = LiveDataTestUtil.getValue(filmsRepository.getDetailTvShow(tvShowId))
        verify(local).getDetailFilm(tvShowId.toString())
        assertNotNull(tvShowEntity)
        assertEquals(detailTvShowResponse.id.toString(), tvShowEntity.data?.filmId)
    }

    @Test
    fun getFavoriteMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FilmEntity>
        `when`(local.getMovieFavorite()).thenReturn(dataSourceFactory)
        filmsRepository.getFavoriteMovies()

        val movieEntities =
            Resource.success(PagedListUtils.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getMovieFavorite()
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShows() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FilmEntity>
        `when`(local.getTvShowFavorite()).thenReturn(dataSourceFactory)
        filmsRepository.getFavoriteTvShows()

        val tvShowEntities =
            Resource.success(PagedListUtils.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getTvShowFavorite()
        assertNotNull(tvShowEntities)
        assertEquals(movieResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }
}