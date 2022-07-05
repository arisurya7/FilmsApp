package com.arisurya.jetpack.filmsapp.ui.detail

import androidx.lifecycle.ViewModel
import com.arisurya.jetpack.filmsapp.data.TvShowEntity
import com.arisurya.jetpack.filmsapp.utils.DataDummy

class DetailTvShowViewModel : ViewModel() {
    private lateinit var showId: String

    fun setSelectedShow(showId: String) {
        this.showId = showId
    }

    fun getTvShow(): TvShowEntity {
        lateinit var show: TvShowEntity
        val showEntities = DataDummy.generateDummyTvShow()
        for (showEntity in showEntities) {
            if (showEntity.showId == showId) {
                show = showEntity
            }
        }
        return show
    }
}