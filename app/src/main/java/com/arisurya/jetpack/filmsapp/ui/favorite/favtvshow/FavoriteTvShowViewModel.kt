package com.arisurya.jetpack.filmsapp.ui.favorite.favtvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity

class FavoriteTvShowViewModel(private val filmsRepository: FilmsRepository) : ViewModel() {
    fun getFavoriteTvShow():LiveData<List<FilmEntity>> = filmsRepository.getFavoriteTvShows()
}