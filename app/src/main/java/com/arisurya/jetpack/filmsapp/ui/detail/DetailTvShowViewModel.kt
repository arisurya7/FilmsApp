package com.arisurya.jetpack.filmsapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity

class DetailTvShowViewModel(private val filmsRepository: FilmsRepository) : ViewModel() {
    private lateinit var showId: String

//    fun setSelectedShow(showId: String) {
//        this.showId = showId
//    }
//
//    fun getTvShow(): LiveData<FilmEntity> = filmsRepository.getDetailTvShow(showId.toInt())
}