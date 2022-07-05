package com.arisurya.jetpack.filmsapp.ui.movie


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.vo.Resource


@Suppress("MemberVisibilityCanBePrivate")
class MoviesViewModel(private val filmsRepository: FilmsRepository) : ViewModel() {

    var choose: Int = 0

    fun setOption(i: Int) {
        choose = i
    }

    fun getMoviesDefault(): LiveData<Resource<PagedList<FilmEntity>>> = filmsRepository.getMovies()

    fun getMoviesSortByRating(): LiveData<Resource<PagedList<FilmEntity>>> =
        filmsRepository.getMoviesSortedByRating()

    fun getMoviesSortByTitle(): LiveData<Resource<PagedList<FilmEntity>>> =
        filmsRepository.getMoviesSortedByTitle()

    fun getMovieOptions(i: Int): LiveData<Resource<PagedList<FilmEntity>>> {
        return when (i) {
            1 -> getMoviesSortByRating()
            2 -> getMoviesSortByTitle()
            else -> getMoviesDefault()
        }
    }

}