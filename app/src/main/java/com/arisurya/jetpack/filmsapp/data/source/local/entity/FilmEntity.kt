package com.arisurya.jetpack.filmsapp.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "filmentities")
data class FilmEntity(
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "filmId")
    var filmId: String,

    @ColumnInfo(name = "title")
<<<<<<< HEAD
    var title: String = "",

    @ColumnInfo(name = "rating")
    var rating: Double = 0.0,

    @ColumnInfo(name = "description")
    var description: String = "",

    @ColumnInfo(name = "tvShow")
    var tvShow: Boolean = false,

    @ColumnInfo(name = "Duration")
    var duration: String = "",

    @ColumnInfo(name = "released")
    var released: String = "",

    @ColumnInfo(name = "language")
    var language: String = "",

    @ColumnInfo(name = "imagePath")
    var imagePath: String = "",

    @ColumnInfo(name = "link")
    var link: String = "",

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false
=======
    var title: String="",

    @ColumnInfo(name = "rating")
    var rating: Double=0.0,

    @ColumnInfo(name = "description")
    var description: String="",

    @ColumnInfo(name = "tvShow")
    var tvShow : Boolean=false,

    @ColumnInfo(name = "Duration")
    var duration: String="",

    @ColumnInfo(name = "released")
    var released: String="",

    @ColumnInfo(name = "language")
    var language: String="",

    @ColumnInfo(name = "imagePath")
    var imagePath: String="",

    @ColumnInfo(name = "link")
    var link: String="",

    @ColumnInfo(name = "favorite")
    var favorite: Boolean=false
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
)