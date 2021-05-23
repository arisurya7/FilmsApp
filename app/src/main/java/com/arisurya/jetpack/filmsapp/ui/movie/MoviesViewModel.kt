package com.arisurya.jetpack.filmsapp.ui.movie


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity


class MoviesViewModel(private val filmsRepository: FilmsRepository) : ViewModel() {

    var choose: Int = 0

    fun setOption(i: Int) {
        choose = i
    }

    fun getMoviesDefault(): LiveData<List<FilmEntity>> = filmsRepository.getMovies()

    fun getMoviesSortByRating(): LiveData<List<FilmEntity>> =
        filmsRepository.getMoviesSortedByRating()

    fun getMoviesSortByTitle(): LiveData<List<FilmEntity>> =
        filmsRepository.getMoviesSortedByTitle()

    fun getMovieOptions(i: Int): LiveData<List<FilmEntity>> {
        return when (i) {
            1 -> getMoviesSortByRating()
            2 -> getMoviesSortByTitle()
            else -> getMoviesDefault()
        }
    }

}