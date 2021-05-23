package com.arisurya.jetpack.filmsapp.data.source.remote.api

import com.arisurya.jetpack.filmsapp.data.source.remote.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @GET("/3/movie/popular")
    fun getMovies(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<MoviesResponse>

    @GET("/3/movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") api_key: String,
        @Query("language") language: String,
    ): Call<DetailMovieResponse>

    @GET("/3/tv/popular")
    fun getTvShow(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<TvShowResponse>

    @GET("/3/tv/{tv_id}")
    fun getDetailTvShow(
        @Path("tv_id") tv_id: Int,
        @Query("api_key") api_key: String,
        @Query("language") language: String,
    ): Call<DetailTvShowResponse>
}