package com.arisurya.jetpack.filmsapp.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.arisurya.jetpack.filmsapp.data.FilmsRepository
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.utils.DataDummy
import com.arisurya.jetpack.filmsapp.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val showId = dummyTvShow.filmId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmsRepository: FilmsRepository

    @Mock
    private lateinit var observer: Observer<Resource<FilmEntity>>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(filmsRepository)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedShow(showId)
        val dummyDetailTvShow = Resource.success(DataDummy.generateDummyTvShow()[0])
        val tvShow = MutableLiveData<Resource<FilmEntity>>()
        tvShow.value = dummyDetailTvShow

        `when`(filmsRepository.getDetailTvShow(showId.toInt())).thenReturn(tvShow)
<<<<<<< HEAD
        val tvShowEntity = viewModel.detailTvShow
        assertNotNull(tvShowEntity)
        viewModel.detailTvShow.observeForever(observer)
=======
        val tvShowEntity = viewModel.getTvShowDetail()
        assertNotNull(tvShowEntity)
        viewModel.getTvShowDetail().observeForever(observer)
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
        verify(observer).onChanged(dummyDetailTvShow)
    }

    @Test
<<<<<<< HEAD
    fun setMovieFavorite() {
=======
    fun setTvShowFavorite(){
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
        viewModel.setTvShowFavorite(DataDummy.generateDummyTvShow()[0])
        verify(filmsRepository).setFavoriteFilm(DataDummy.generateDummyTvShow()[0], true)
        verifyNoMoreInteractions(filmsRepository)
    }
}