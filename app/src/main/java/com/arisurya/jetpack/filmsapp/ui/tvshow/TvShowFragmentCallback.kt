package com.arisurya.jetpack.filmsapp.ui.tvshow

import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity

interface TvShowFragmentCallback {
    fun onShareClick(tvShow: FilmEntity)
    fun onVisitClick(tvShow: FilmEntity)
}