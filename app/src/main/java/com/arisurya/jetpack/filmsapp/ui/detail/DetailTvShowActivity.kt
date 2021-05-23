package com.arisurya.jetpack.filmsapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.databinding.ActivityDetailTvShowBinding
import com.arisurya.jetpack.filmsapp.databinding.ContentDetailTvShowBinding
import com.arisurya.jetpack.filmsapp.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide

class DetailTvShowActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TV = "extra_tv"
    }

    private lateinit var detailTvShowBinding: ContentDetailTvShowBinding
    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding
    private lateinit var viewModel: DetailTvShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailTvShowBinding = activityDetailTvShowBinding.detailContent
        setContentView(activityDetailTvShowBinding.root)

//        val factory = ViewModelFactory.getInstance(this)
//        viewModel = ViewModelProvider(
//            this,
//            factory
//        )[DetailTvShowViewModel::class.java]
//        val extras = intent.extras
//        setProgressBar(true)
//        if (extras != null) {
//            val showId = extras.getString(EXTRA_TV)
//            if (showId != null) {
//                viewModel.setSelectedShow(showId)
//                viewModel.getTvShow().observe(this, { show ->
//                    populateMovie(show)
//                    setProgressBar(false)
//                })
//
//            }
//        }
    }

    private fun populateMovie(show: FilmEntity) {
        detailTvShowBinding.tvShowTitle.text = show.title
        detailTvShowBinding.tvShowRating.text = show.rating.toString()
        detailTvShowBinding.tvShowReleased.text = show.released
        detailTvShowBinding.tvShowDuration.text = show.duration
        detailTvShowBinding.tvShowDesc.text = show.description
        detailTvShowBinding.tvShowLanguage.text = show.language

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w185${show.imagePath}")
            .into(detailTvShowBinding.imgBgDetail)

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w185${show.imagePath}")
            .into(detailTvShowBinding.imgShowPoster)
    }

    private fun setProgressBar(state: Boolean) {
        if (state) {
            activityDetailTvShowBinding.progressBar.visibility = View.VISIBLE
            activityDetailTvShowBinding.content.visibility = View.GONE
        } else {
            activityDetailTvShowBinding.progressBar.visibility = View.GONE
            activityDetailTvShowBinding.content.visibility = View.VISIBLE
        }
    }
}