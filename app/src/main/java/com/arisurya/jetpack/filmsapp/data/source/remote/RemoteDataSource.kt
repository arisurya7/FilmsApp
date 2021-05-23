package com.arisurya.jetpack.filmsapp.data.source.remote

import android.util.Log
import com.arisurya.jetpack.filmsapp.BuildConfig
import com.arisurya.jetpack.filmsapp.data.source.remote.api.ApiConfig
import com.arisurya.jetpack.filmsapp.data.source.remote.response.*
import com.arisurya.jetpack.filmsapp.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {
        private const val API_KEY = BuildConfig.ApiKey
        private const val PAGE = 1
        private const val LANGUAGE = "en-US"
        private const val TAG = "RemoteDataSource"
    }

    fun getMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getMovies(API_KEY, LANGUAGE, PAGE)
        client.enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                if (response.isSuccessful) {
                    val listMovies = response.body()?.results as List<ResultsItemMovie>
                    callback.onAllMovieReceived(listMovies)
                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    fun getDetailMovie(movieId: Int, callback: LoadDetailMovieCallback) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getDetailMovie(movieId, API_KEY, LANGUAGE)
        client.enqueue(object : Callback<DetailMovieResponse> {
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {

                if (response.isSuccessful) {
                    val detailMovieResponse = response.body() as DetailMovieResponse
                    callback.onAllDetailMovieReceived(detailMovieResponse)
                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }

            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    fun getTvShows(callback: LoadTvShowCallback) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getTvShow(API_KEY, LANGUAGE, PAGE)
        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                if (response.isSuccessful) {
                    val listTvShow = response.body()?.results as List<ResultsItemTvShow>
                    callback.onAllTvShowReceived(listTvShow)
                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }


            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    fun getDetailTvShow(tvShowId: Int, callback: LoadDetailTvShowCallback) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getDetailTvShow(tvShowId, API_KEY, LANGUAGE)
        client.enqueue(object : Callback<DetailTvShowResponse> {
            override fun onResponse(
                call: Call<DetailTvShowResponse>,
                response: Response<DetailTvShowResponse>
            ) {

                if (response.isSuccessful) {
                    val detailTvShowResponse = response.body() as DetailTvShowResponse
                    callback.onAllDetailTvShowReceived(detailTvShowResponse)
                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }

            }

            override fun onFailure(call: Call<DetailTvShowResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }


    interface LoadMoviesCallback {
        fun onAllMovieReceived(moviesResponse: List<ResultsItemMovie>)
    }

    interface LoadDetailMovieCallback {
        fun onAllDetailMovieReceived(detailMovieResponse: DetailMovieResponse)
    }

    interface LoadTvShowCallback {
        fun onAllTvShowReceived(tvShowResponse: List<ResultsItemTvShow>)
    }

    interface LoadDetailTvShowCallback {
        fun onAllDetailTvShowReceived(detailTvShowResponse: DetailTvShowResponse)
    }
}