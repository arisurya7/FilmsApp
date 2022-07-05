package com.arisurya.jetpack.filmsapp.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.databinding.ListItemsMoviesBinding
import com.arisurya.jetpack.filmsapp.ui.detail.DetailMovieActivity
import com.bumptech.glide.Glide

class MoviesAdapter : PagedListAdapter<FilmEntity, MoviesAdapter.MoviesViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FilmEntity>() {
            override fun areItemsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean {
                return oldItem.filmId == newItem.filmId
            }

            override fun areContentsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean {
                return oldItem == newItem
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val listItemsMoviesBinding =
            ListItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(listItemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) holder.bind(movie)
    }


    class MoviesViewHolder(private val binding: ListItemsMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: FilmEntity) {
            with(binding) {
                tvMovieTitle.text = movie.title
                tvMovieRating.text = movie.rating.toString()
                tvMovieDesc.text = movie.description
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w185${movie.imagePath}")
                    .into(imgMoviePoster)


                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.filmId)
                    itemView.context.startActivity(intent)
                }
            }
        }

    }
}