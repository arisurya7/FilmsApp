package com.arisurya.jetpack.filmsapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.data.source.remote.RemoteDataSource
import com.arisurya.jetpack.filmsapp.data.source.remote.response.DetailMovieResponse
import com.arisurya.jetpack.filmsapp.data.source.remote.response.DetailTvShowResponse
import com.arisurya.jetpack.filmsapp.data.source.remote.response.ResultsItemMovie
import com.arisurya.jetpack.filmsapp.data.source.remote.response.ResultsItemTvShow
import java.util.*
import kotlin.collections.ArrayList


class FilmsRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    FilmsDataSource {

    companion object {
        @Volatile
        private var instance: FilmsRepository? = null
        fun getInstance(remoteData: RemoteDataSource): FilmsRepository =
            instance ?: synchronized(this) {
                instance ?: FilmsRepository(remoteData).apply { instance = this }
            }
    }


    override fun getMovies(): LiveData<List<FilmEntity>> {
        val movieResults = MutableLiveData<List<FilmEntity>>()
        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMovieReceived(moviesResponse: List<ResultsItemMovie>) {
                val moviesList = ArrayList<FilmEntity>()
                for (response in moviesResponse) {
                    val movie = FilmEntity(
                        filmId = response.id.toString(),
                        title = response.title,
                        rating = response.voteAverage,
                        description = response.overview,
                        tvShow = false,
                        imagePath = response.posterPath
                    )
                    moviesList.add(movie)
                }
                movieResults.postValue(moviesList)
            }

        })
        return movieResults
    }

    override fun getMoviesSortedByRating(): LiveData<List<FilmEntity>> {
        val movieResults = MutableLiveData<List<FilmEntity>>()
        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMovieReceived(moviesResponse: List<ResultsItemMovie>) {
                val moviesList = ArrayList<FilmEntity>()
                for (response in moviesResponse) {
                    val movie = FilmEntity(
                        filmId = response.id.toString(),
                        title = response.title,
                        rating = response.voteAverage,
                        description = response.overview,
                        tvShow = false,
                        imagePath = response.posterPath
                    )
                    moviesList.add(movie)
                }
                movieResults.postValue(moviesList.sortedWith(compareByDescending { it.rating }))
            }

        })
        return movieResults
    }

    override fun getMoviesSortedByTitle(): LiveData<List<FilmEntity>> {
        val movieResults = MutableLiveData<List<FilmEntity>>()
        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMovieReceived(moviesResponse: List<ResultsItemMovie>) {
                val moviesList = ArrayList<FilmEntity>()
                for (response in moviesResponse) {
                    val movie = FilmEntity(
                        filmId = response.id.toString(),
                        title = response.title,
                        rating = response.voteAverage,
                        description = response.overview,
                        tvShow = false,
                        imagePath = response.posterPath
                    )
                    moviesList.add(movie)
                }
                movieResults.postValue(moviesList.sortedWith(compareBy { it.title }))
            }

        })
        return movieResults
    }

    override fun getDetailMovie(movieId: Int): LiveData<FilmEntity> {
        val detailMovie = MutableLiveData<FilmEntity>()
        remoteDataSource.getDetailMovie(movieId, object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onAllDetailMovieReceived(detailMovieResponse: DetailMovieResponse) {
                val movie = FilmEntity(
                    detailMovieResponse.id.toString(),
                    detailMovieResponse.title,
                    detailMovieResponse.voteAverage,
                    detailMovieResponse.overview,
                    false,
                    convertIntToDurationFormat(detailMovieResponse.runtime),
                    detailMovieResponse.releaseDate,
                    Locale(detailMovieResponse.originalLanguage).displayName,
                    detailMovieResponse.posterPath,
                    "https://www.themoviedb.org/movie/${detailMovieResponse.id}"
                )
                detailMovie.postValue(movie)
            }

        })
        return detailMovie
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