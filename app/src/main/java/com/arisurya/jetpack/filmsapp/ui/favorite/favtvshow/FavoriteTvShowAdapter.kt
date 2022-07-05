package com.arisurya.jetpack.filmsapp.ui.favorite.favtvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.databinding.ListItemsMoviesBinding
<<<<<<< HEAD
import com.arisurya.jetpack.filmsapp.ui.detail.DetailTvShowActivity
import com.bumptech.glide.Glide

class FavoriteTvShowAdapter :
    PagedListAdapter<FilmEntity, FavoriteTvShowAdapter.FavoriteTvShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FilmEntity>() {
=======
import com.arisurya.jetpack.filmsapp.ui.detail.DetailMovieActivity
import com.arisurya.jetpack.filmsapp.ui.detail.DetailTvShowActivity
import com.bumptech.glide.Glide

class FavoriteTvShowAdapter : PagedListAdapter<FilmEntity, FavoriteTvShowAdapter.FavoriteTvShowViewHolder>(DIFF_CALLBACK) {

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
    private var listTvShow = ArrayList<FilmEntity>()

    fun setFavoriteTvShow(movies: List<FilmEntity>?) {
        if (movies == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(movies)
    }
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvShowViewHolder {
        val listItemsMoviesBinding =
            ListItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteTvShowViewHolder(listItemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: FavoriteTvShowViewHolder, position: Int) {
        val favTvShow = getItem(position)
<<<<<<< HEAD
        if (favTvShow != null) holder.bind(favTvShow)
    }

=======
        if(favTvShow!=null) holder.bind(favTvShow)
    }

//    override fun getItemCount(): Int = listTvShow.size

>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c

    class FavoriteTvShowViewHolder(private val binding: ListItemsMoviesBinding) :
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
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_TV, movie.filmId)
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