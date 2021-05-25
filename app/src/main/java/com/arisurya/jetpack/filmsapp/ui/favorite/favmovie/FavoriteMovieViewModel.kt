package com.arisurya.jetpack.filmsapp.ui.favorite.favmovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity

class FavoriteMovieViewModel(private val filmsRepository: FilmsRepository): ViewModel() {

    fun getFavoriteMovies(): LiveData<List<FilmEntity>> = filmsRepository.getFavoriteMovies()
}