package com.arisurya.jetpack.filmsapp.ui.detail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.arisurya.jetpack.filmsapp.data.MovieEntity
import com.arisurya.jetpack.filmsapp.databinding.ActivityDetailMovieBinding
import com.arisurya.jetpack.filmsapp.databinding.ContentDetailMovieBinding
import com.arisurya.jetpack.filmsapp.utils.DataDummy
import com.bumptech.glide.Glide

class DetailMovieActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var detailMovieBinding: ContentDetailMovieBinding
    private lateinit var viewModel: DetailMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailMovieBinding = activityDetailMovieBinding.detailContent
        setContentView(activityDetailMovieBinding.root)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMovieViewModel::class.java]
        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                for (movie in DataDummy.generateDummyMovies()) {
                    if (movie.movieId == movieId) {
                        populateMovie(viewModel.getMovie())
                    }
                }


            }
        }
    }

    private fun populateMovie(movie: MovieEntity) {
        detailMovieBinding.tvMovieTitle.text = movie.title
        detailMovieBinding.tvMovieRating.text = movie.rating.toString()
        detailMovieBinding.tvMovieReleased.text = movie.released
        detailMovieBinding.tvMovieDuration.text = movie.duration
        detailMovieBinding.tvMovieDesc.text = movie.description
        detailMovieBinding.tvMovieLanguage.text = movie.language
        detailMovieBinding.btnVisitMovie.setOnClickListener(this)
        detailMovieBinding.btnShare.setOnClickListener(this)

        Glide.with(this)
            .load(movie.imagePath)
            .into(detailMovieBinding.imgBgDetail)

        Glide.with(this)
            .load(movie.imagePath)
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
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(viewModel.getMovie().link)))
    }

    private fun shareMovie() {
        val message = """
            [Detail Movie]
            Title           : ${viewModel.getMovie().title}
            Rating          : ${viewModel.getMovie().rating}
            Duration        : ${viewModel.getMovie().duration}
            Released        : ${viewModel.getMovie().released}
            Language        : ${viewModel.getMovie().language}
            Description     : ${viewModel.getMovie().description}
            Link            : ${viewModel.getMovie().link}
            
            Created by Ari Surya
        """.trimIndent()
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, message)
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject here")
        startActivity(Intent.createChooser(shareIntent, "Share movie via"))
    }


}