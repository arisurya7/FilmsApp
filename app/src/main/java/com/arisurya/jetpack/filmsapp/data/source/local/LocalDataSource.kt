package com.arisurya.jetpack.filmsapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null
        fun getInstance(filmDao: FilmDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(filmDao)
    }

    fun getMovies(): DataSource.Factory<Int, FilmEntity> = mFilmDao.getMovies()

    fun getTvShows(): DataSource.Factory<Int, FilmEntity> = mFilmDao.getTvShows()

    fun getDetailFilm(filmId: String): LiveData<FilmEntity> = mFilmDao.getDetailFilm(filmId)

    fun insertFilm(film: List<FilmEntity>) = mFilmDao.insertFilms(film)

    fun updateDetailFilm(released: String, duration: String, language: String, filmId: String) {
        mFilmDao.updateFilmByDetail(released, duration, language, filmId)
    }

    fun getMoviesSortByRating(): DataSource.Factory<Int, FilmEntity> =
        mFilmDao.getMoviesSortRating()

    fun getMoviesSortByTitle(): DataSource.Factory<Int, FilmEntity> = mFilmDao.getMoviesSortTitle()

    fun getTvShowSortByRating(): DataSource.Factory<Int, FilmEntity> =
        mFilmDao.getTvShowSortRating()

    fun getTvShowSortByTitle(): DataSource.Factory<Int, FilmEntity> = mFilmDao.getTvShowSortTitle()

    fun getMovieFavorite(): DataSource.Factory<Int, FilmEntity> = mFilmDao.getFavoriteMovies()

    fun getTvShowFavorite(): DataSource.Factory<Int, FilmEntity> = mFilmDao.getFavoriteTvShows()

    fun setFavoriteFilm(film: FilmEntity, newState: Boolean) {
        film.favorite = newState
        mFilmDao.updateFilmByFavorite(film)
    }

}