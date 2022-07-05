package com.arisurya.jetpack.filmsapp.ui.favorite.favmovie

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

<<<<<<< HEAD
class FavoriteMovieAdapter :
    PagedListAdapter<FilmEntity, FavoriteMovieAdapter.FavoriteMoviesViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FilmEntity>() {
=======
class FavoriteMovieAdapter : PagedListAdapter<FilmEntity, FavoriteMovieAdapter.FavoriteMoviesViewHolder>(DIFF_CALLBACK) {

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FilmEntity>(){
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
            override fun areItemsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean {
                return oldItem.filmId == newItem.filmId
            }

            override fun areContentsTheSame(oldItem: FilmEntity, newItem: FilmEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

<<<<<<< HEAD
=======
    private var listMovies = ArrayList<FilmEntity>()

    fun setFavoriteMovies(movies: List<FilmEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMoviesViewHolder {
        val listItemsMoviesBinding =
            ListItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMoviesViewHolder(listItemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: FavoriteMoviesViewHolder, position: Int) {
        val favMovie = getItem(position)
<<<<<<< HEAD
        if (favMovie != null) {
=======
        if (favMovie!=null){
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
            holder.bind(favMovie)
        }
    }

<<<<<<< HEAD
=======
//    override fun getItemCount(): Int = listMovies.size

>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c

    class FavoriteMoviesViewHolder(private val binding: ListItemsMoviesBinding) :
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


<<<<<<< HEAD
    fun getSwipedData(swipedPosition: Int): FilmEntity? = getItem(swipedPosition)
=======
    fun getSwipedData(swipedPosition : Int): FilmEntity? = getItem(swipedPosition)
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
}