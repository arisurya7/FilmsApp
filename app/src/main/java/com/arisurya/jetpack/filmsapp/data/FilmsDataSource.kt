package com.arisurya.jetpack.filmsapp.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.vo.Resource


interface FilmsDataSource {

    fun getMovies(): LiveData<Resource<PagedList<FilmEntity>>>
    fun getMoviesSortedByRating(): LiveData<Resource<PagedList<FilmEntity>>>
    fun getMoviesSortedByTitle(): LiveData<Resource<PagedList<FilmEntity>>>
    fun getDetailMovie(movieId: Int): LiveData<Resource<FilmEntity>>
    fun getTvShows(): LiveData<Resource<PagedList<FilmEntity>>>
    fun getTvShowsSortedByRating(): LiveData<Resource<PagedList<FilmEntity>>>
    fun getTvShowsSortedByTitle(): LiveData<Resource<PagedList<FilmEntity>>>
    fun getDetailTvShow(tvShowId: Int): LiveData<Resource<FilmEntity>>
    fun getFavoriteMovies():LiveData<PagedList<FilmEntity>>
    fun getFavoriteTvShows():LiveData<PagedList<FilmEntity>>
    fun setFavoriteFilm(filmEntity: FilmEntity, state:Boolean)
}