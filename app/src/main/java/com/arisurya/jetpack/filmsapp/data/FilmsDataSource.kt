package com.arisurya.jetpack.filmsapp.data

import androidx.lifecycle.LiveData
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity


interface FilmsDataSource {

    fun getMovies(): LiveData<List<FilmEntity>>
    fun getMoviesSortedByRating(): LiveData<List<FilmEntity>>
    fun getMoviesSortedByTitle(): LiveData<List<FilmEntity>>
    fun getDetailMovie(movieId: Int): LiveData<FilmEntity>
    fun getTvShows(): LiveData<List<FilmEntity>>
    fun getTvShowsSortedByRating(): LiveData<List<FilmEntity>>
    fun getTvShowsSortedByTitle(): LiveData<List<FilmEntity>>
    fun getDetailTvShow(tvShowId: Int): LiveData<FilmEntity>
}