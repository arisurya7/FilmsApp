package com.arisurya.jetpack.filmsapp.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.di.Injection
import com.arisurya.jetpack.filmsapp.ui.detail.DetailMovieViewModel
import com.arisurya.jetpack.filmsapp.ui.detail.DetailTvShowViewModel
import com.arisurya.jetpack.filmsapp.ui.movie.MoviesViewModel
import com.arisurya.jetpack.filmsapp.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val mFilmsRepository: FilmsRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository()).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(mFilmsRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(mFilmsRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(mFilmsRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                DetailTvShowViewModel(mFilmsRepository) as T
            }
            else -> throw Throwable("Unknown ViewModelClass : ${modelClass.name}")
        }
    }


}