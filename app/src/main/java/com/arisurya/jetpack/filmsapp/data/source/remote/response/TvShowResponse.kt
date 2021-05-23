package com.arisurya.jetpack.filmsapp.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShowResponse(

    @field:SerializedName("page")
    val page: Int,

    @field:SerializedName("results")
    val results: List<ResultsItemTvShow>
)

data class ResultsItemTvShow(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("poster_path")
    val posterPath: String
)


data class DetailTvShowResponse(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("first_air_date")
    val firstAirDate: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("original_language")
    val originalLanguage: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @field:SerializedName("episode_run_time")
    val episodeRunTime: List<Int>
)
