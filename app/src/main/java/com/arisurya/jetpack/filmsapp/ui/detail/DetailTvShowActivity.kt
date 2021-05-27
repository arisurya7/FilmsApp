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

class DetailTvShowActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_TV = "extra_tv"
    }

    private lateinit var detailTvShowBinding: ContentDetailTvShowBinding
    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding
    private lateinit var viewModel: DetailTvShowViewModel
    private lateinit var linkVisit:String
    private lateinit var shareMessage:String
    private lateinit var filmEntity: FilmEntity

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
        val extras = intent.extras
        setProgressBar(true)
        if (extras != null) {
            val showId = extras.getString(EXTRA_TV)
            if (showId != null) {
                viewModel.setSelectedShow(showId)
                viewModel.getTvShowDetail().observe(this, { show ->
                    if(show!=null){
                        when(show.status){
                            Status.LOADING -> setProgressBar(true)
                            Status.SUCCESS -> {
                                setProgressBar(false)
                                populateMovie(show.data)
                                show.data?.let { setFavoriteState(it.favorite) }
                            }
                            Status.ERROR -> {
                                setProgressBar(false)
                                Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })

            }
        }
    }

    private fun populateMovie(show: FilmEntity?) {
        detailTvShowBinding.tvShowTitle.text = show?.title
        detailTvShowBinding.tvShowRating.text = show?.rating.toString()
        detailTvShowBinding.tvShowReleased.text = show?.released
        detailTvShowBinding.tvShowDuration.text = show?.duration
        detailTvShowBinding.tvShowDesc.text = show?.description
        detailTvShowBinding.tvShowLanguage.text = show?.language
        detailTvShowBinding.btnFav.setOnClickListener(this)

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w185${show?.imagePath}")
            .into(detailTvShowBinding.imgBgDetail)

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w185${show?.imagePath}")
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

    override fun onClick(v: View?) {
        when(v){
            detailTvShowBinding.btnFav->{
                setFavoriteTvShow()
            }
        }
    }

    private fun setFavoriteState(state: Boolean){
        if(state) detailTvShowBinding.btnFav.setImageResource(R.drawable.ic_favorite_full)
        else detailTvShowBinding.btnFav.setImageResource(R.drawable.ic_favorite_outline)
    }

    private fun showToastAddToFavorite(){
        val toastView = layoutInflater.inflate(
            R.layout.toast_success_layout, findViewById(R.id.toast_add)
        )
        with(Toast(applicationContext)){
            duration = Toast.LENGTH_SHORT
            view = toastView
            show()
        }
    }

    private fun showToastRemoveFromFavorite(){
        val toastView = layoutInflater.inflate(
            R.layout.toast_failed_layout, findViewById(R.id.toast_remove)
        )
        with(Toast(applicationContext)){
            duration = Toast.LENGTH_SHORT
            view = toastView
            show()
        }
    }

    private fun setFavoriteTvShow(){
        if(viewModel.detailTvShow.value?.data?.favorite == true)showToastRemoveFromFavorite()
        else showToastAddToFavorite()
        viewModel.getTvShowDetail().observe(this,{movieWithDetail->
            if(movieWithDetail!=null){
                if(movieWithDetail.data!=null)
                    filmEntity= movieWithDetail.data
            }
        })
        viewModel.setTvShowFavorite(filmEntity)
    }
}