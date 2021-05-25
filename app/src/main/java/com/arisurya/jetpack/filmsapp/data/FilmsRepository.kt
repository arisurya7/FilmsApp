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

    override fun getTvShows(): LiveData<Resource<List<FilmEntity>>> {
        return object :
            NetworkBoundResource<List<FilmEntity>, List<ResultsItemTvShow>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<FilmEntity>> =
                localDataSource.getTvShows()

            override fun shouldFetch(data: List<FilmEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ResultsItemTvShow>>> =
                remoteDataSource.getTvShows()

            override fun saveCallResult(tvResponse: List<ResultsItemTvShow>) {
                val tvList = ArrayList<FilmEntity>()
                for (response in tvResponse) {
                    val movie = FilmEntity(
                        filmId = response.id.toString(),
                        title = response.name,
                        rating = response.voteAverage,
                        description = response.overview,
                        tvShow = true,
                        imagePath = response.posterPath,
                        link = "https://www.themoviedb.org/tv/${response.id}"
                    )
                    tvList.add(movie)
                }
                localDataSource.insertFilm(tvList)
            }

        }.asLiveData()
    }

    override fun getTvShowsSortedByRating(): LiveData<Resource<List<FilmEntity>>> {
        return object :
            NetworkBoundResource<List<FilmEntity>, List<ResultsItemTvShow>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<FilmEntity>> =
                localDataSource.getTvShowSortByRating()

            override fun shouldFetch(data: List<FilmEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ResultsItemTvShow>>> =
                remoteDataSource.getTvShows()

            override fun saveCallResult(moviesResponse: List<ResultsItemTvShow>) {
                localDataSource.getTvShowSortByRating()
            }

        }.asLiveData()
    }

    override fun getTvShowsSortedByTitle(): LiveData<Resource<List<FilmEntity>>> {
        return object :
            NetworkBoundResource<List<FilmEntity>, List<ResultsItemTvShow>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<FilmEntity>> =
                localDataSource.getTvShowSortByTitle()

            override fun shouldFetch(data: List<FilmEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ResultsItemTvShow>>> =
                remoteDataSource.getTvShows()

            override fun saveCallResult(moviesResponse: List<ResultsItemTvShow>) {
                localDataSource.getTvShowSortByTitle()
            }

        }.asLiveData()
    }

    override fun getDetailTvShow(tvShowId: Int): LiveData<Resource<FilmEntity>> {

        return object : NetworkBoundResource<FilmEntity, DetailTvShowResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<FilmEntity> =
                localDataSource.getDetailFilm(tvShowId.toString())

            override fun shouldFetch(data: FilmEntity?): Boolean =
                data?.released == ""

            override fun createCall(): LiveData<ApiResponse<DetailTvShowResponse>> =
                remoteDataSource.getDetailTvShow(tvShowId)

            override fun saveCallResult(data: DetailTvShowResponse) =
                localDataSource.updateDetailFilm(
                    data.firstAirDate,
                    convertIntToDurationFormat(if (data.episodeRunTime.isEmpty()) 0 else data.episodeRunTime[0]),
                    Locale(data.originalLanguage).displayName,
                    tvShowId.toString()
                )

        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<List<FilmEntity>> =
        localDataSource.getMovieFavorite()

    override fun getFavoriteTvShows(): LiveData<List<FilmEntity>> =
        localDataSource.getTvShowFavorite()

    override fun setFavoriteFilm(film: FilmEntity, state: Boolean) =
        appExecutors.diskIO().execute{localDataSource.setFavoriteFilm(film, state)}

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