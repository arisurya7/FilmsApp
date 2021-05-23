package com.arisurya.jetpack.filmsapp.data.source.local.entity

data class FilmEntity(
    var filmId: String ="",
    var title: String="",
    var rating: Double = 0.0,
    var description: String="",
    var tvShow : Boolean=false,
    var duration: String="",
    var released: String="",
    var language: String="",
    var imagePath: String="",
    var link: String=""
)