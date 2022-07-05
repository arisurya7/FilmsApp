package com.arisurya.jetpack.filmsapp.ui.tvshow

import androidx.lifecycle.ViewModel
import com.arisurya.jetpack.filmsapp.data.TvShowEntity
import com.arisurya.jetpack.filmsapp.utils.DataDummy

@Suppress("MemberVisibilityCanBePrivate")
class TvShowViewModel : ViewModel() {
    var choose: Int = 0

    fun setOptionShow(i: Int) {
        choose = i
    }

    fun getTvShowDefault(): List<TvShowEntity> = DataDummy.generateDummyTvShow()

    fun getTvShowSortByRating(): List<TvShowEntity> {
        val tvShow = DataDummy.generateDummyTvShow().toMutableList()
        return tvShow.sortedWith(compareByDescending { it.rating })
    }

    fun getTvShowSortByTitle(): List<TvShowEntity> {
        val tvShow = DataDummy.generateDummyTvShow().toMutableList()
        return tvShow.sortedWith(compareBy { it.title })
    }

    fun getTvShowOptions(i: Int): List<TvShowEntity> {
        return when (i) {
            1 -> getTvShowSortByRating()
            2 -> getTvShowSortByTitle()
            else -> getTvShowDefault()
        }
    }
}