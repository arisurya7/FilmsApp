package com.arisurya.jetpack.filmsapp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.arisurya.jetpack.filmsapp.data.source.remote.RemoteDataSource
import com.arisurya.jetpack.filmsapp.utils.DataDummy
import com.arisurya.jetpack.filmsapp.utils.LiveDataTestUtil
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.doAnswer
import org.mockito.Mockito.*

class FilmsRepositoryTest {

    @get: Rule
    var instanceTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val filmsRepository = FakeFilmsRepository(remote)

    private val movieResponse = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponse[0].id
    private val tvShowResponse = DataDummy.generateRemoteDummyTvShow()
    private val tvShowId = tvShowResponse[0].id
    private val detailMovieResponse = DataDummy.generateRemoteDummyDetailMovie()
    private val detailTvShowResponse = DataDummy.generateRemoteDummyDetailTvShow()

    @Test
    fun getMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMovieReceived(movieResponse)
            null
        }.`when`(remote).getMovies(any())

        val movieEntities = LiveDataTestUtil.getValue(filmsRepository.getMovies())
        verify(remote).getMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getMoviesSortedByRating() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMovieReceived(movieResponse)
            null
        }.`when`(remote).getMovies(any())

        val movieEntities = LiveDataTestUtil.getValue(filmsRepository.getMoviesSortedByRating())
        verify(remote).getMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getMoviesSortedByTitle() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMovieReceived(movieResponse)
            null
        }.`when`(remote).getMovies(any())

        val movieEntities = LiveDataTestUtil.getValue(filmsRepository.getMoviesSortedByTitle())
        verify(remote).getMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailMovieCallback)
                .onAllDetailMovieReceived(detailMovieResponse)
            null
        }.`when`(remote).getDetailMovie(eq(movieId), any())

        val movieEntity = LiveDataTestUtil.getValue(filmsRepository.getDetailMovie(movieId))
        verify(remote).getDetailMovie(eq(movieId), any())
        assertNotNull(movieEntity)
        assertEquals(detailMovieResponse.id.toString(), movieEntity.filmId)
    }

    @Test
    fun getTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvShowResponse)
            null
        }.`when`(remote).getTvShows(any())

        val tvShowEntities = LiveDataTestUtil.getValue(filmsRepository.getTvShows())
        verify(remote).getTvShows(any())
        assertNotNull(tvShowEntities)
        assertEquals(movieResponse.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getTvShowsSortedByRating() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvShowResponse)
            null
        }.`when`(remote).getTvShows(any())

        val tvShowEntities = LiveDataTestUtil.getValue(filmsRepository.getTvShowsSortedByRating())
        verify(remote).getTvShows(any())
        assertNotNull(tvShowEntities)
        assertEquals(movieResponse.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getTvShowsSortedByTitle() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvShowResponse)
            null
        }.`when`(remote).getTvShows(any())

        val tvShowEntities = LiveDataTestUtil.getValue(filmsRepository.getTvShowsSortedByTitle())
        verify(remote).getTvShows(any())
        assertNotNull(tvShowEntities)
        assertEquals(movieResponse.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getDetailTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailTvShowCallback)
                .onAllDetailTvShowReceived(detailTvShowResponse)
            null
        }.`when`(remote).getDetailTvShow(eq(tvShowId), any())

        val tvShowEntity = LiveDataTestUtil.getValue(filmsRepository.getDetailTvShow(tvShowId))
        verify(remote).getDetailTvShow(eq(tvShowId), any())
        assertNotNull(tvShowEntity)
        assertEquals(detailTvShowResponse.id.toString(), tvShowEntity.filmId)
    }
}