package com.arisurya.jetpack.filmsapp.ui.movie

import androidx.lifecycle.ViewModel
import com.arisurya.jetpack.filmsapp.data.MovieEntity
import com.arisurya.jetpack.filmsapp.utils.DataDummy


class MoviesViewModel : ViewModel() {
    var choose: Int = 0

    fun setOption(i: Int) {
        choose = i
    }

    fun getMoviesDefault(): List<MovieEntity> = DataDummy.generateDummyMovies()
    fun getMoviesSortByRating(): List<MovieEntity> {
        val movies = DataDummy.generateDummyMovies().toMutableList()
        return movies.sortedWith(compareByDescending { it.rating })
    }

    fun getMoviesSortByTitle(): List<MovieEntity> {
        val movies = DataDummy.generateDummyMovies().toMutableList()
        return movies.sortedWith(compareBy { it.title })
    }

    fun getMovieOptions(i: Int): List<MovieEntity> {
        return when (i) {
            1 -> getMoviesSortByRating()
            2 -> getMoviesSortByTitle()
            else -> getMoviesDefault()
        }
    }

}