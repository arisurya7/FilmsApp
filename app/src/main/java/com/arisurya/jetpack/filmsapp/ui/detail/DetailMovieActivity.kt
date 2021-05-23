package com.arisurya.jetpack.filmsapp.ui.detail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.databinding.ActivityDetailMovieBinding
import com.arisurya.jetpack.filmsapp.databinding.ContentDetailMovieBinding
import com.arisurya.jetpack.filmsapp.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide

class DetailMovieActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var detailMovieBinding: ContentDetailMovieBinding
    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private lateinit var viewModel: DetailMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailMovieBinding = activityDetailMovieBinding.detailContent
        setContentView(activityDetailMovieBinding.root)

        val factory = ViewModelFactory.getInstance()

        viewModel = ViewModelProvider(
            this,
            factory
        )[DetailMovieViewModel::class.java]
        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            setProgressBar(true)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                viewModel.getMovie().observe(this, { movie ->
                    setProgressBar(false)
                    populateMovie(movie)
                })
            }
        }
    }

    private fun populateMovie(movie: FilmEntity) {
        detailMovieBinding.tvMovieTitle.text = movie.title
        detailMovieBinding.tvMovieRating.text = movie.rating.toString()
        detailMovieBinding.tvMovieReleased.text = movie.released
        detailMovieBinding.tvMovieDuration.text = movie.duration
        detailMovieBinding.tvMovieDesc.text = movie.description
        detailMovieBinding.tvMovieLanguage.text = movie.language
        detailMovieBinding.btnVisitMovie.setOnClickListener(this)
        detailMovieBinding.btnShare.setOnClickListener(this)

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w185${movie.imagePath}")
            .into(detailMovieBinding.imgBgDetail)

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w185${movie.imagePath}")
            .into(detailMovieBinding.imgMoviePoster)

    }

    override fun onClick(v: View?) {
        when (v) {
            detailMovieBinding.btnShare -> {
                shareMovie()
            }
            detailMovieBinding.btnVisitMovie -> {
                visitMovie()
            }
        }
    }

    private fun visitMovie() {
        viewModel.getMovie().observe(this, { movie ->
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(movie.link)))
        })

    }

    private fun shareMovie() {
        viewModel.getMovie().observe(this, { movie ->
            val message = """
            [Lets Watching]
            Title           : ${movie.title}
            Rating          : ${movie.rating}
            Duration        : ${movie.duration}
            Released        : ${movie.released}
            Language        : ${movie.language}
            Description     : ${movie.description}
            Link            : ${movie.link}

            Download FilmApps
        """.trimIndent()
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share via")
                .setText(message)
                .startChooser()
        })


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


}