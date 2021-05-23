package com.arisurya.jetpack.filmsapp.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity


@Suppress("MemberVisibilityCanBePrivate")
class TvShowViewModel(private val filmsRepository: FilmsRepository) : ViewModel() {
    var choose: Int = 0

    fun setOptionShow(i: Int) {
        choose = i
    }

    fun getTvShowDefault(): LiveData<List<FilmEntity>> = filmsRepository.getTvShows()

    fun getTvShowSortByRating(): LiveData<List<FilmEntity>> =
        filmsRepository.getTvShowsSortedByRating()

    fun getTvShowSortByTitle(): LiveData<List<FilmEntity>> =
        filmsRepository.getTvShowsSortedByTitle()

    fun getTvShowOptions(i: Int): LiveData<List<FilmEntity>> {
        return when (i) {
            1 -> getTvShowSortByRating()
            2 -> getTvShowSortByTitle()
            else -> getTvShowDefault()
        }
    }
}