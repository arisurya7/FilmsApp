package com.arisurya.jetpack.filmsapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.arisurya.jetpack.filmsapp.data.TvShowEntity
import com.arisurya.jetpack.filmsapp.databinding.ActivityDetailTvShowBinding
import com.arisurya.jetpack.filmsapp.databinding.ContentDetailTvShowBinding
import com.arisurya.jetpack.filmsapp.utils.DataDummy
import com.bumptech.glide.Glide

class DetailTvShowActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TV = "extra_tv"
    }

    private lateinit var detailTvShowBinding: ContentDetailTvShowBinding
    private lateinit var viewModel: DetailTvShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailTvShowBinding = activityDetailTvShowBinding.detailContent
        setContentView(activityDetailTvShowBinding.root)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailTvShowViewModel::class.java]
        val extras = intent.extras
        if (extras != null) {
            val showId = extras.getString(EXTRA_TV)
            if (showId != null) {
                viewModel.setSelectedShow(showId)
                for (show in DataDummy.generateDummyTvShow()) {
                    if (show.showId == showId) {
                        populateMovie(viewModel.getTvShow())
                    }
                }


            }
        }
    }

    private fun populateMovie(show: TvShowEntity) {
        detailTvShowBinding.tvShowTitle.text = show.title
        detailTvShowBinding.tvShowRating.text = show.rating.toString()
        detailTvShowBinding.tvShowReleased.text = show.released
        detailTvShowBinding.tvShowDuration.text = show.duration
        detailTvShowBinding.tvShowDesc.text = show.description
        detailTvShowBinding.tvShowLanguage.text = show.language

        Glide.with(this)
            .load(show.imagePath)
            .into(detailTvShowBinding.imgBgDetail)

        Glide.with(this)
            .load(show.imagePath)
            .into(detailTvShowBinding.imgShowPoster)
    }
}