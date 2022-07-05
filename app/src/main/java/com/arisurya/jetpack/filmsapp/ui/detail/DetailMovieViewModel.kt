package com.arisurya.jetpack.filmsapp.ui.detail

import androidx.lifecycle.ViewModel
import com.arisurya.jetpack.filmsapp.data.MovieEntity
import com.arisurya.jetpack.filmsapp.utils.DataDummy

class DetailMovieViewModel : ViewModel() {
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): MovieEntity {
        lateinit var movie: MovieEntity
        val movieEntities = DataDummy.generateDummyMovies()
        for (movieEntity in movieEntities) {
            if (movieEntity.movieId == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }


}