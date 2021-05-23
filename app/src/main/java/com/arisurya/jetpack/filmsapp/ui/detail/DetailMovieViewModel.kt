package com.arisurya.jetpack.filmsapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.vo.Resource


class DetailMovieViewModel(private val filmsRepository: FilmsRepository) : ViewModel() {
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): LiveData<Resource<FilmEntity>> = filmsRepository.getDetailMovie(movieId.toInt())

}