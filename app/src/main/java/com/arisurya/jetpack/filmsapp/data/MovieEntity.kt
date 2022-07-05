package com.arisurya.jetpack.filmsapp.data

data class MovieEntity(
    var movieId: String,
    var title: String,
    var rating: Double,
    var duration: String,
    var released: String,
    var language: String,
    var description: String,
    var imagePath: String,
    var link: String
)

