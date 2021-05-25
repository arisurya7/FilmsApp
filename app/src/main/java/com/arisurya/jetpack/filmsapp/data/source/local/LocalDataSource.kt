package com.arisurya.jetpack.filmsapp.data.source.local

import androidx.lifecycle.LiveData
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null
        fun getInstance(filmDao: FilmDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(filmDao)
    }

    fun getMovies(): LiveData<List<FilmEntity>> = mFilmDao.getMovies()

    fun getTvShows(): LiveData<List<FilmEntity>> = mFilmDao.getTvShows()

    fun getDetailFilm(filmId: String): LiveData<FilmEntity> = mFilmDao.getDetailFilm(filmId)

    fun insertFilm(film: List<FilmEntity>) = mFilmDao.insertFilms(film)

    fun updateDetailFilm(released: String, duration: String, language: String, filmId: String) {
        mFilmDao.updateFilmByDetail(released, duration, language, filmId)
    }

    fun getMoviesSortByRating(): LiveData<List<FilmEntity>> = mFilmDao.getMoviesSortRating()

    fun getMoviesSortByTitle(): LiveData<List<FilmEntity>> = mFilmDao.getMoviesSortTitle()

    fun getTvShowSortByRating(): LiveData<List<FilmEntity>> = mFilmDao.getTvShowSortRating()

    fun getTvShowSortByTitle(): LiveData<List<FilmEntity>> = mFilmDao.getTvShowSortTitle()

    fun getMovieFavorite(): LiveData<List<FilmEntity>> = mFilmDao.getFavoriteMovies()

    fun getTvShowFavorite(): LiveData<List<FilmEntity>> = mFilmDao.getFavoriteTvShows()

    fun setFavoriteFilm(film: FilmEntity, newState:Boolean){
        film.favorite = newState
        mFilmDao.updateFilmByFavorite(film)
    }

}