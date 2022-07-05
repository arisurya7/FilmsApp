package com.arisurya.jetpack.filmsapp.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity

@Dao
interface FilmDao {
    @Query("SELECT * FROM filmentities WHERE tvShow = 0")
    fun getMovies(): DataSource.Factory<Int, FilmEntity>

    @Query("SELECT * FROM filmentities WHERE tvShow=0 ORDER BY rating DESC")
    fun getMoviesSortRating(): DataSource.Factory<Int, FilmEntity>

    @Query("SELECT * FROM filmentities WHERE tvShow=0 ORDER BY title ASC")
    fun getMoviesSortTitle(): DataSource.Factory<Int, FilmEntity>

    @Query("SELECT * FROM filmentities WHERE tvShow=1")
    fun getTvShows(): DataSource.Factory<Int, FilmEntity>

    @Query("SELECT * FROM filmentities WHERE tvShow=1 ORDER BY rating DESC")
    fun getTvShowSortRating(): DataSource.Factory<Int, FilmEntity>

    @Query("SELECT * FROM filmentities WHERE tvShow=1 ORDER BY title ASC")
    fun getTvShowSortTitle(): DataSource.Factory<Int, FilmEntity>

    @Query("SELECT * FROM filmentities WHERE filmId = :filmId")
    fun getDetailFilm(filmId: String): LiveData<FilmEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilms(film: List<FilmEntity>)

    @Update
    fun updateFilm(film: FilmEntity)

    @Update
    fun updateFilmByFavorite(film: FilmEntity)

    @Query("UPDATE filmentities SET released=:released, duration=:duration, language=:language WHERE filmId=:filmId")
    fun updateFilmByDetail(released: String, duration: String, language: String, filmId: String)

    @Query("SELECT * FROM filmentities WHERE tvShow = 0 AND favorite =1")
    fun getFavoriteMovies(): DataSource.Factory<Int, FilmEntity>

    @Query("SELECT * FROM filmentities WHERE tvShow = 1 AND favorite =1")
    fun getFavoriteTvShows(): DataSource.Factory<Int, FilmEntity>

}