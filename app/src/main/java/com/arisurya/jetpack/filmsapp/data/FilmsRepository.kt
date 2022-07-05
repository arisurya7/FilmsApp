package com.arisurya.jetpack.filmsapp.data

<<<<<<< HEAD

import androidx.lifecycle.LiveData
=======
import android.graphics.pdf.PdfDocument
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
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


<<<<<<< HEAD
@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
=======
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
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


    override fun getMovies(): LiveData<Resource<PagedList<FilmEntity>>> {
        return object :
            NetworkBoundResource<PagedList<FilmEntity>, List<ResultsItemMovie>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<FilmEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<FilmEntity>?): Boolean =
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

    override fun getMoviesSortedByRating(): LiveData<Resource<PagedList<FilmEntity>>> {
        return object :
            NetworkBoundResource<PagedList<FilmEntity>, List<ResultsItemMovie>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<FilmEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getMoviesSortByRating(), config).build()
            }

            override fun shouldFetch(data: PagedList<FilmEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ResultsItemMovie>>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(moviesResponse: List<ResultsItemMovie>) {
                localDataSource.getMoviesSortByRating()
            }

        }.asLiveData()
    }

    override fun getMoviesSortedByTitle(): LiveData<Resource<PagedList<FilmEntity>>> {
        return object :
            NetworkBoundResource<PagedList<FilmEntity>, List<ResultsItemMovie>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<FilmEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getMoviesSortByTitle(), config).build()
            }

            override fun shouldFetch(data: PagedList<FilmEntity>?): Boolean =
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

    override fun getTvShows(): LiveData<Resource<PagedList<FilmEntity>>> {
        return object :
            NetworkBoundResource<PagedList<FilmEntity>, List<ResultsItemTvShow>>(appExecutors) {
<<<<<<< HEAD
            override fun loadFromDB(): LiveData<PagedList<FilmEntity>> {
=======
            override fun loadFromDB(): LiveData<PagedList<FilmEntity>>{
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getTvShows(), config).build()
            }
<<<<<<< HEAD

=======
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
            override fun shouldFetch(data: PagedList<FilmEntity>?): Boolean =
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

    override fun getTvShowsSortedByRating(): LiveData<Resource<PagedList<FilmEntity>>> {
        return object :
            NetworkBoundResource<PagedList<FilmEntity>, List<ResultsItemTvShow>>(appExecutors) {
<<<<<<< HEAD
            override fun loadFromDB(): LiveData<PagedList<FilmEntity>> {
=======
            override fun loadFromDB(): LiveData<PagedList<FilmEntity>>{
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getTvShowSortByRating(), config).build()
            }

            override fun shouldFetch(data: PagedList<FilmEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ResultsItemTvShow>>> =
                remoteDataSource.getTvShows()

            override fun saveCallResult(moviesResponse: List<ResultsItemTvShow>) {
                localDataSource.getTvShowSortByRating()
            }

        }.asLiveData()
    }

    override fun getTvShowsSortedByTitle(): LiveData<Resource<PagedList<FilmEntity>>> {
        return object :
            NetworkBoundResource<PagedList<FilmEntity>, List<ResultsItemTvShow>>(appExecutors) {
<<<<<<< HEAD
            override fun loadFromDB(): LiveData<PagedList<FilmEntity>> {
=======
            override fun loadFromDB(): LiveData<PagedList<FilmEntity>>{
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getTvShowSortByTitle(), config).build()
            }

            override fun shouldFetch(data: PagedList<FilmEntity>?): Boolean =
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

    override fun getFavoriteMovies(): LiveData<PagedList<FilmEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getMovieFavorite(), config).build()
    }

    override fun getFavoriteTvShows(): LiveData<PagedList<FilmEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getTvShowFavorite(), config).build()
    }

    override fun setFavoriteFilm(film: FilmEntity, state: Boolean) =
<<<<<<< HEAD
        appExecutors.diskIO().execute { localDataSource.setFavoriteFilm(film, state) }
=======
        appExecutors.diskIO().execute{localDataSource.setFavoriteFilm(film, state)}
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c

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