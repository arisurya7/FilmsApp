package com.arisurya.jetpack.filmsapp.ui.movie


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.vo.Resource


class MoviesViewModel(private val filmsRepository: FilmsRepository) : ViewModel() {

    var choose: Int = 0

    fun setOption(i: Int) {
        choose = i
    }

    fun getMoviesDefault(): LiveData<Resource<List<FilmEntity>>> = filmsRepository.getMovies()

    fun getMoviesSortByRating(): LiveData<Resource<List<FilmEntity>>> =
        filmsRepository.getMoviesSortedByRating()

    fun getMoviesSortByTitle(): LiveData<Resource<List<FilmEntity>>> =
        filmsRepository.getMoviesSortedByTitle()

    fun getMovieOptions(i: Int): LiveData<Resource<List<FilmEntity>>> {
        return when (i) {
            1 -> getMoviesSortByRating()
            2 -> getMoviesSortByTitle()
            else -> getMoviesDefault()
        }
    }

}