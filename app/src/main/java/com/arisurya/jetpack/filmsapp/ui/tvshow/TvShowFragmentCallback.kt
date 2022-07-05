package com.arisurya.jetpack.filmsapp.ui.tvshow

import com.arisurya.jetpack.filmsapp.data.TvShowEntity

interface TvShowFragmentCallback {
    fun onShareClick(tvShow : TvShowEntity)
    fun onVisitClick(tvShow: TvShowEntity)
}