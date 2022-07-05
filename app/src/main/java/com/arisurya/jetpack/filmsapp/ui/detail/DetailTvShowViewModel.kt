package com.arisurya.jetpack.filmsapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.vo.Resource

class DetailTvShowViewModel(private val filmsRepository: FilmsRepository) : ViewModel() {
    private var showId = MutableLiveData<String>()

    fun setSelectedShow(showId: String) {
        this.showId.value = showId
    }

    var detailTvShow: LiveData<Resource<FilmEntity>> =
        Transformations.switchMap(showId) { mShowId ->
            showId.value?.let { filmsRepository.getDetailTvShow(mShowId.toInt()) }
        }

    fun setTvShowFavorite(filmEntity: FilmEntity) {
        val newState = !filmEntity.favorite
        filmsRepository.setFavoriteFilm(filmEntity, newState)
    }
}