package com.arisurya.jetpack.filmsapp.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity

@Dao
interface FilmDao {
    @Query("SELECT * FROM filmentities WHERE tvShow = 0")
    fun getMovies(): LiveData<List<FilmEntity>>

    @Query("SELECT * FROM filmentities WHERE tvShow=0 ORDER BY rating DESC")
    fun getMoviesSortRating(): LiveData<List<FilmEntity>>

    @Query("SELECT * FROM filmentities WHERE tvShow=0 ORDER BY title ASC")
    fun getMoviesSortTitle(): LiveData<List<FilmEntity>>

    @Query("SELECT * FROM filmentities WHERE tvShow=1")
    fun getTvShows(): LiveData<List<FilmEntity>>

    @Query("SELECT * FROM filmentities WHERE tvShow=1 ORDER BY rating DESC")
    fun getTvShowSortRating(): LiveData<List<FilmEntity>>

    @Query("SELECT * FROM filmentities WHERE tvShow=1 ORDER BY title ASC")
    fun getTvShowSortTitle(): LiveData<List<FilmEntity>>

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
    fun getFavoriteMovies(): LiveData<List<FilmEntity>>

    @Query("SELECT * FROM filmentities WHERE tvShow = 1 AND favorite =1")
    fun getFavoriteTvShows(): LiveData<List<FilmEntity>>

}