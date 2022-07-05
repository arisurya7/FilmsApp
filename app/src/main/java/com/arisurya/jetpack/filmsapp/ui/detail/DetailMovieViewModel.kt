package com.arisurya.jetpack.filmsapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.vo.Resource


class DetailMovieViewModel(private val filmsRepository: FilmsRepository) : ViewModel() {
<<<<<<< HEAD
    private var movieId = MutableLiveData<String>()
=======
    var movieId = MutableLiveData<String>()
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c

    fun setSelectedMovie(movieId: String) {
        this.movieId.value = movieId
    }

    var detailMovie: LiveData<Resource<FilmEntity>> =
        Transformations.switchMap(movieId) { mMovieId ->
            movieId.value?.let { filmsRepository.getDetailMovie(mMovieId.toInt()) }
        }

<<<<<<< HEAD
=======
    fun getMovieDetail(): LiveData<Resource<FilmEntity>> = detailMovie

//    fun setMovieFavorite() {
//        val movieResource = detailMovie.value
//        if (movieResource != null) {
//            val filmEntity = movieResource.data
//            if (filmEntity != null) {
//                val newState = !filmEntity.favorite
//                filmsRepository.setFavoriteFilm(filmEntity, newState)
//            }
//        }
//
//    }

>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
    fun setMovieFavorite(filmEntity: FilmEntity) {
        val newState = !filmEntity.favorite
        filmsRepository.setFavoriteFilm(filmEntity, newState)
    }
}