package com.arisurya.jetpack.filmsapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arisurya.jetpack.filmsapp.data.source.local.LocalDataSource
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.data.source.remote.ApiResponse
import com.arisurya.jetpack.filmsapp.data.source.remote.RemoteDataSource
import com.arisurya.jetpack.filmsapp.data.source.remote.response.DetailMovieResponse
import com.arisurya.jetpack.filmsapp.data.source.remote.response.DetailTvShowResponse
import com.arisurya.jetpack.filmsapp.data.source.remote.response.ResultsItemMovie
import com.arisurya.jetpack.filmsapp.data.source.remote.response.ResultsItemTvShow
import com.arisurya.jetpack.filmsapp.utils.AppExecutors
import com.arisurya.jetpack.filmsapp.vo.Resource
import java.util.*
import kotlin.collections.ArrayList


class FilmsRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    FilmsDataSource {

    companion object {
        @Volatile
        private var instance: FilmsRepository? = null
        fun getInstance(
            remoteData: RemoteDataSource,
            localDataSource: LocalDataSource,
            appExecutors: AppExecutors
        ): FilmsRepository =
            instance ?: synchronized(this) {
                instance ?: FilmsRepository(
                    remoteData,
                    localDataSource,
                    appExecutors
                ).apply { instance = this }
            }
    }


    override fun getMovies(): LiveData<Resource<List<FilmEntity>>> {
        return object :
            NetworkBoundResource<List<FilmEntity>, List<ResultsItemMovie>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<FilmEntity>> =
                localDataSource.getMovies()

            override fun shouldFetch(data: List<FilmEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ResultsItemMovie>>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(moviesResponse: List<ResultsItemMovie>) {
                val moviesList = ArrayList<FilmEntity>()
                for (response in moviesResponse) {
                    val movie = FilmEntity(
                        filmId = response.id.toString(),
                        title = response.title,
                        rating = response.voteAverage,
                        description = response.overview,
                        tvShow = false,
                        imagePath = response.posterPath,
                        link = "https://www.themoviedb.org/movie/${response.id}"
                    )
                    moviesList.add(movie)
                }
                localDataSource.insertFilm(moviesList)


            }

        }.asLiveData()
    }

    override fun getMoviesSortedByRating(): LiveData<Resource<List<FilmEntity>>> {
        return object :
            NetworkBoundResource<List<FilmEntity>, List<ResultsItemMovie>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<FilmEntity>> =
                localDataSource.getMoviesSortByRating()

            override fun shouldFetch(data: List<FilmEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ResultsItemMovie>>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(moviesResponse: List<ResultsItemMovie>) {
                localDataSource.getMoviesSortByRating()
            }

        }.asLiveData()
    }

    override fun getMoviesSortedByTitle(): LiveData<Resource<List<FilmEntity>>> {
        return object :
            NetworkBoundResource<List<FilmEntity>, List<ResultsItemMovie>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<FilmEntity>> =
                localDataSource.getMoviesSortByTitle()

            override fun shouldFetch(data: List<FilmEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ResultsItemMovie>>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(moviesResponse: List<ResultsItemMovie>) {
                localDataSource.getMoviesSortByTitle()
            }

        }.asLiveData()
    }

    override fun getDetailMovie(movieId: Int): LiveData<Resource<FilmEntity>> {
        return object : NetworkBoundResource<FilmEntity, DetailMovieResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<FilmEntity> =
                localDataSource.getDetailFilm(movieId.toString())

            override fun shouldFetch(data: FilmEntity?): Boolean =
                data?.released == ""

            override fun createCall(): LiveData<ApiResponse<DetailMovieResponse>> =
                remoteDataSource.getDetailMovie(movieId)

            override fun saveCallResult(data: DetailMovieResponse) =
                localDataSource.updateDetailFilm(
                    data.releaseDate,
                    convertIntToDurationFormat(data.runtime),
                    Locale(data.originalLanguage).displayName,
                    movieId.toString()
                )

        }.asLiveData()
    }

    override fun getTvShows(): LiveData<List<FilmEntity>> {
        val tvShowResults = MutableLiveData<List<FilmEntity>>()
        remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvShowResponse: List<ResultsItemTvShow>) {
                val tvShowList = ArrayList<FilmEntity>()
                for (response in tvShowResponse) {
                    val tvShow = FilmEntity(
                        filmId = response.id.toString(),
                        title = response.name,
                        rating = response.voteAverage,
                        description = response.overview,
                        tvShow = true,
                        imagePath = response.posterPath,
                        link = "https://www.themoviedb.org/tv/${response.id}"
                    )
                    tvShowList.add(tvShow)
                }
                tvShowResults.postValue(tvShowList)
            }

        })
        return tvShowResults
    }

    override fun getTvShowsSortedByRating(): LiveData<List<FilmEntity>> {
        val tvShowResults = MutableLiveData<List<FilmEntity>>()
        remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvShowResponse: List<ResultsItemTvShow>) {
                val tvShowList = ArrayList<FilmEntity>()
                for (response in tvShowResponse) {
                    val tvShow = FilmEntity(
                        filmId = response.id.toString(),
                        title = response.name,
                        rating = response.voteAverage,
                        description = response.overview,
                        tvShow = true,
                        imagePath = response.posterPath,
                        link = "https://www.themoviedb.org/tv/${response.id}"

                    )
                    tvShowList.add(tvShow)
                }
                tvShowResults.postValue(tvShowList.sortedWith(compareByDescending { it.rating }))
            }

        })
        return tvShowResults
    }

    override fun getTvShowsSortedByTitle(): LiveData<List<FilmEntity>> {
        val tvShowResults = MutableLiveData<List<FilmEntity>>()
        remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvShowResponse: List<ResultsItemTvShow>) {
                val tvShowList = ArrayList<FilmEntity>()
                for (response in tvShowResponse) {
                    val tvShow = FilmEntity(
                        filmId = response.id.toString(),
                        title = response.name,
                        rating = response.voteAverage,
                        description = response.overview,
                        tvShow = true,
                        imagePath = response.posterPath,
                        link = "https://www.themoviedb.org/tv/${response.id}"
                    )
                    tvShowList.add(tvShow)
                }
                tvShowResults.postValue(tvShowList.sortedWith(compareBy { it.title }))
            }

        })
        return tvShowResults

    }

    override fun getDetailTvShow(tvShowId: Int): LiveData<FilmEntity> {
        val detailTvShow = MutableLiveData<FilmEntity>()
        remoteDataSource.getDetailTvShow(
            tvShowId,
            object : RemoteDataSource.LoadDetailTvShowCallback {
                override fun onAllDetailTvShowReceived(detailTvShowResponse: DetailTvShowResponse) {
                    val tvShow = FilmEntity(
                        detailTvShowResponse.id.toString(),
                        detailTvShowResponse.name,
                        detailTvShowResponse.voteAverage,
                        detailTvShowResponse.overview,
                        true,
                        convertIntToDurationFormat(if (detailTvShowResponse.episodeRunTime.isEmpty()) 0 else detailTvShowResponse.episodeRunTime[0]),
                        detailTvShowResponse.firstAirDate,
                        Locale(detailTvShowResponse.originalLanguage).displayName,
                        detailTvShowResponse.posterPath,
                        "https://www.themoviedb.org/tv/${detailTvShowResponse.id}"
                    )
                    detailTvShow.postValue(tvShow)
                }

            })
        return detailTvShow

    }

    fun convertIntToDurationFormat(minute: Int): String {
        return if (minute == 0) {
            "-"
        } else if (minute % 60 == 0) {
            "${minute / 60}h"
        } else if (minute % 60 != 0 && minute % 60 == minute) {
            "${minute}m"
        } else {
            "${(minute - (minute % 60)) / 60}h ${minute % 60}m"
        }
    }
}