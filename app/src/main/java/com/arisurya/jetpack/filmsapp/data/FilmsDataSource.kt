package com.arisurya.jetpack.filmsapp.data

import androidx.lifecycle.LiveData
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.vo.Resource


interface FilmsDataSource {

    fun getMovies(): LiveData<Resource<List<FilmEntity>>>
    fun getMoviesSortedByRating(): LiveData<Resource<List<FilmEntity>>>
    fun getMoviesSortedByTitle(): LiveData<Resource<List<FilmEntity>>>
    fun getDetailMovie(movieId: Int): LiveData<Resource<FilmEntity>>
    fun getTvShows(): LiveData<List<FilmEntity>>
    fun getTvShowsSortedByRating(): LiveData<List<FilmEntity>>
    fun getTvShowsSortedByTitle(): LiveData<List<FilmEntity>>
    fun getDetailTvShow(tvShowId: Int): LiveData<FilmEntity>
}