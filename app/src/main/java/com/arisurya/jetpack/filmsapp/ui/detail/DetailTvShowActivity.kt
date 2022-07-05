package com.arisurya.jetpack.filmsapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.arisurya.jetpack.filmsapp.R
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.databinding.ActivityDetailTvShowBinding
import com.arisurya.jetpack.filmsapp.databinding.ContentDetailTvShowBinding
import com.arisurya.jetpack.filmsapp.viewmodel.ViewModelFactory
import com.arisurya.jetpack.filmsapp.vo.Status
import com.bumptech.glide.Glide

@Suppress("NestedLambdaShadowedImplicitParameter", "DEPRECATION")
class DetailTvShowActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_TV = "extra_tv"
    }

    private lateinit var detailTvShowBinding: ContentDetailTvShowBinding
    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding
    private lateinit var viewModel: DetailTvShowViewModel
    lateinit var filmEntity: FilmEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailTvShowBinding = activityDetailTvShowBinding.detailContent
        setContentView(activityDetailTvShowBinding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(
            this,
            factory
        )[DetailTvShowViewModel::class.java]

        intent.extras?.let {
            it.getString(EXTRA_TV)?.apply {
                setProgressBar(true)
                viewModel.setSelectedShow(this)
                viewModel.detailTvShow.observe(this@DetailTvShowActivity, { show ->
                    if (show != null) {
                        when (show.status) {
                            Status.LOADING -> setProgressBar(true)
                            Status.SUCCESS -> {
                                setProgressBar(false)
                                populateMovie(show.data)
                                show.data?.let { setFavoriteState(it.favorite) }
                            }
                            Status.ERROR -> {
                                setProgressBar(false)
                                Toast.makeText(
                                    this@DetailTvShowActivity,
                                    "Something Wrong",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                })
            }
        }


    }

    private fun populateMovie(show: FilmEntity?) {
        detailTvShowBinding.apply {
            tvShowTitle.text = show?.title
            tvShowRating.text = show?.rating.toString()
            tvShowReleased.text = show?.released
            tvShowDuration.text = show?.duration
            tvShowDesc.text = show?.description
            tvShowLanguage.text = show?.language
            btnFav.setOnClickListener(this@DetailTvShowActivity)

            Glide.with(this@DetailTvShowActivity)
                .load("https://image.tmdb.org/t/p/w185${show?.imagePath}")
                .into(imgBgDetail)

            Glide.with(this@DetailTvShowActivity)
                .load("https://image.tmdb.org/t/p/w185${show?.imagePath}")
                .into(imgShowPoster)
        }

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

    override fun onClick(v: View?) {
        when (v) {
            detailTvShowBinding.btnFav -> {
                setFavoriteTvShow()
            }
        }
    }

    private fun setFavoriteState(state: Boolean) {
        if (state) detailTvShowBinding.btnFav.setImageResource(R.drawable.ic_favorite_full)
        else detailTvShowBinding.btnFav.setImageResource(R.drawable.ic_favorite_outline)
    }

    private fun showToastAddToFavorite() {
        val toastView = layoutInflater.inflate(
            R.layout.toast_success_layout, findViewById(R.id.toast_add)
        )
        with(Toast(applicationContext)) {
            duration = Toast.LENGTH_SHORT
            view = toastView
            show()
        }
    }

    private fun showToastRemoveFromFavorite() {
        val toastView = layoutInflater.inflate(
            R.layout.toast_failed_layout, findViewById(R.id.toast_remove)
        )
        with(Toast(applicationContext)) {
            duration = Toast.LENGTH_SHORT
            view = toastView
            show()
        }
    }

    private fun setFavoriteTvShow() {
        if (viewModel.detailTvShow.value?.data?.favorite == true) showToastRemoveFromFavorite()
        else showToastAddToFavorite()
        viewModel.detailTvShow.observe(this, { tvShowDetail ->
            if (tvShowDetail != null) {
                if (tvShowDetail.data != null) {
                    filmEntity = tvShowDetail.data
                }
            }
        })
        viewModel.setTvShowFavorite(filmEntity)
    }
}