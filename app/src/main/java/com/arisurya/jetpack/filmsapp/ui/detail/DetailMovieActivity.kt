package com.arisurya.jetpack.filmsapp.ui.detail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import com.arisurya.jetpack.filmsapp.R
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.databinding.ActivityDetailMovieBinding
import com.arisurya.jetpack.filmsapp.databinding.ContentDetailMovieBinding
import com.arisurya.jetpack.filmsapp.viewmodel.ViewModelFactory
import com.arisurya.jetpack.filmsapp.vo.Status
import com.bumptech.glide.Glide

@Suppress("NestedLambdaShadowedImplicitParameter", "DEPRECATION")
class DetailMovieActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var detailMovieBinding: ContentDetailMovieBinding
    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private lateinit var viewModel: DetailMovieViewModel
    private lateinit var linkVisit:String
    private lateinit var shareMessage:String
    private lateinit var filmEntity: FilmEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailMovieBinding = activityDetailMovieBinding.detailContent
        setContentView(activityDetailMovieBinding.root)

        val factory = ViewModelFactory.getInstance(this)

        viewModel = ViewModelProvider(
            this,
            factory
        )[DetailMovieViewModel::class.java]
        intent.extras?.let {
            it.getString(EXTRA_MOVIE)?.apply {
                setProgressBar(true)
                viewModel.setSelectedMovie(this)
                viewModel.detailMovie.observe(this@DetailMovieActivity,{ movieWithDetail ->
                    if (movieWithDetail != null) {
                        when (movieWithDetail.status) {
                            Status.LOADING -> setProgressBar(true)
                            Status.SUCCESS -> {
                                setProgressBar(false)
                                populateMovie(movieWithDetail.data)
                                val state = movieWithDetail.data?.favorite
                                state?.let { setFavoriteState(it) }
                            }
                            Status.ERROR -> {
                                setProgressBar(false)
                                Toast.makeText(this@DetailMovieActivity, "Something Wrong", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                } )
            }
        }
    }

    private fun populateMovie(movie: FilmEntity?) {
        detailMovieBinding.apply {
            tvMovieTitle.text = movie?.title
            tvMovieRating.text = movie?.rating.toString()
            tvMovieReleased.text = movie?.released
            tvMovieDuration.text = movie?.duration
            tvMovieDesc.text = movie?.description
            tvMovieLanguage.text = movie?.language
            btnVisitMovie.setOnClickListener(this@DetailMovieActivity)
            btnShare.setOnClickListener(this@DetailMovieActivity)
            btnFav.setOnClickListener(this@DetailMovieActivity)

            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/w185${movie?.imagePath}")
                .into(imgBgDetail)

            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/w185${movie?.imagePath}")
                .into(imgMoviePoster)

        }


    }

    override fun onClick(v: View?) {
        when (v) {
            detailMovieBinding.btnFav->{
                setFavoriteMovie()
            }
            detailMovieBinding.btnShare -> {
                shareMovie()
            }
            detailMovieBinding.btnVisitMovie -> {
                visitMovie()
            }
        }
    }

    private fun visitMovie() {
        viewModel.detailMovie.observe(this, { movie ->
            linkVisit = movie.data?.link.toString()
        })
        if(linkVisit.isNotEmpty())
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(linkVisit)))
    }

    private fun shareMovie() {
        viewModel.detailMovie.observe(this, { movie ->
            shareMessage = """
            [Lets Watching]
            Title           : ${movie.data?.title}
            Rating          : ${movie.data?.rating}
            Duration        : ${movie.data?.duration}
            Released        : ${movie.data?.released}
            Language        : ${movie.data?.language}
            Description     : ${movie.data?.description}
            Link            : ${movie.data?.link}

            Download FilmApps
        """.trimIndent()
        })
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle("Share via")
            .setText(shareMessage)
            .startChooser()

    }

    private fun setProgressBar(state: Boolean) {
        if (state) {
            activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
            activityDetailMovieBinding.content.visibility = View.GONE
        } else {
            activityDetailMovieBinding.progressBar.visibility = View.GONE
            activityDetailMovieBinding.content.visibility = View.VISIBLE
        }
    }

    private fun setFavoriteState(state: Boolean){
        if(state)
            detailMovieBinding.btnFav.setImageResource(R.drawable.ic_favorite_full)
        else
            detailMovieBinding.btnFav.setImageResource(R.drawable.ic_favorite_outline)
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

    private fun setFavoriteMovie(){
        if(viewModel.detailMovie.value?.data?.favorite == true)showToastRemoveFromFavorite()
        else showToastAddToFavorite()
        viewModel.detailMovie.observe(this,{movieWithDetail ->
            if(movieWithDetail!=null){
                if(movieWithDetail.data!=null){
                    filmEntity = movieWithDetail.data
                }
            }
        })
        viewModel.setMovieFavorite(filmEntity)
    }

}