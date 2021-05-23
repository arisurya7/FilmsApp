package com.arisurya.jetpack.filmsapp.di


import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(): FilmsRepository {
        val remoteDataSource = RemoteDataSource()
        return FilmsRepository.getInstance(remoteDataSource)
    }
}