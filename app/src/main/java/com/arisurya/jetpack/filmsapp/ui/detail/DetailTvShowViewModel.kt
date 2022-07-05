package com.arisurya.jetpack.filmsapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.vo.Resource

class DetailTvShowViewModel(private val filmsRepository: FilmsRepository) : ViewModel() {
<<<<<<< HEAD
    private var showId = MutableLiveData<String>()
=======
    var showId = MutableLiveData<String>()
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c

    fun setSelectedShow(showId: String) {
        this.showId.value = showId
    }

<<<<<<< HEAD
    var detailTvShow: LiveData<Resource<FilmEntity>> =
        Transformations.switchMap(showId) { mShowId ->
            showId.value?.let { filmsRepository.getDetailTvShow(mShowId.toInt()) }
        }

    fun setTvShowFavorite(filmEntity: FilmEntity) {
        val newState = !filmEntity.favorite
        filmsRepository.setFavoriteFilm(filmEntity, newState)
=======
    var detailTvShow: LiveData<Resource<FilmEntity>> = Transformations.switchMap(showId) { mShowId ->
        showId.value?.let { filmsRepository.getDetailTvShow(mShowId.toInt()) }
    }

    fun getTvShowDetail():LiveData<Resource<FilmEntity>> = detailTvShow

    fun setTvShowFavorite(filmEntity: FilmEntity){
        val newState = !filmEntity.favorite
        filmsRepository.setFavoriteFilm(filmEntity,newState)
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
    }
}