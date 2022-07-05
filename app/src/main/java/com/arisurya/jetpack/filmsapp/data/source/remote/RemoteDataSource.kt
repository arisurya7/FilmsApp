package com.arisurya.jetpack.filmsapp.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    fun getMovies(): MutableLiveData<ApiResponse<List<ResultsItemMovie>>> {
        EspressoIdlingResource.increment()
        val resultListMovies = MutableLiveData<ApiResponse<List<ResultsItemMovie>>>()
        val client = ApiConfig.getApiService().getMovies(API_KEY, LANGUAGE, PAGE)
        client.enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                if (response.isSuccessful) {
                    val listMovies = response.body()?.results as List<ResultsItemMovie>
                    resultListMovies.value = ApiResponse.success(listMovies)
                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
        return resultListMovies
    }

    fun getDetailMovie(movieId: Int): LiveData<ApiResponse<DetailMovieResponse>> {
        EspressoIdlingResource.increment()
        val resultDetailMovie = MutableLiveData<ApiResponse<DetailMovieResponse>>()
        val client = ApiConfig.getApiService().getDetailMovie(movieId, API_KEY, LANGUAGE)
        client.enqueue(object : Callback<DetailMovieResponse> {
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {

                if (response.isSuccessful) {
                    val detailMovieResponse = response.body() as DetailMovieResponse
                    resultDetailMovie.value = ApiResponse.success(detailMovieResponse)
                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }

            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })

        return resultDetailMovie
    }

    fun getTvShows(): MutableLiveData<ApiResponse<List<ResultsItemTvShow>>> {
        EspressoIdlingResource.increment()
        val resultListTvShow = MutableLiveData<ApiResponse<List<ResultsItemTvShow>>>()
        val client = ApiConfig.getApiService().getTvShow(API_KEY, LANGUAGE, PAGE)
        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                if (response.isSuccessful) {
                    val listTvShow = response.body()?.results as List<ResultsItemTvShow>
                    resultListTvShow.value = ApiResponse.success(listTvShow)
                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }


            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })

        return resultListTvShow
    }

    fun getDetailTvShow(tvShowId: Int): LiveData<ApiResponse<DetailTvShowResponse>> {
        EspressoIdlingResource.increment()
        val resultDetailTvShow = MutableLiveData<ApiResponse<DetailTvShowResponse>>()
        val client = ApiConfig.getApiService().getDetailTvShow(tvShowId, API_KEY, LANGUAGE)
        client.enqueue(object : Callback<DetailTvShowResponse> {
            override fun onResponse(
                call: Call<DetailTvShowResponse>,
                response: Response<DetailTvShowResponse>
            ) {

                if (response.isSuccessful) {
                    val detailTvShowResponse = response.body() as DetailTvShowResponse
                    resultDetailTvShow.value = ApiResponse.success(detailTvShowResponse)
                    EspressoIdlingResource.decrement()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }

            }

            override fun onFailure(call: Call<DetailTvShowResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })

        return resultDetailTvShow
    }
}