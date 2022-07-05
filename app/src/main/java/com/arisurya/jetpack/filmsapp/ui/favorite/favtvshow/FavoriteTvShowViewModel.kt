package com.arisurya.jetpack.filmsapp.ui.favorite.favtvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity

class FavoriteTvShowViewModel(private val filmsRepository: FilmsRepository) : ViewModel() {
    fun getFavoriteTvShow(): LiveData<PagedList<FilmEntity>> = filmsRepository.getFavoriteTvShows()

    fun setFavorite(filmEntity: FilmEntity) {
        val newState = !filmEntity.favorite
        filmsRepository.setFavoriteFilm(filmEntity, newState)
    }
}