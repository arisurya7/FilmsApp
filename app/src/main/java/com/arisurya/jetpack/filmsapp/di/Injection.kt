package com.arisurya.jetpack.filmsapp.di


import android.content.Context
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.LocalDataSource
import com.arisurya.jetpack.filmsapp.data.source.local.room.FilmDatabase
import com.arisurya.jetpack.filmsapp.data.source.remote.RemoteDataSource
import com.arisurya.jetpack.filmsapp.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): FilmsRepository {
        val remoteDataSource = RemoteDataSource()
        val database = FilmDatabase.getInstance(context)
        val localDataSource = LocalDataSource.getInstance(database.filmDao())
        val appExecutors = AppExecutors()
        return FilmsRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}