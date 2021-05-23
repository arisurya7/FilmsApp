package com.arisurya.jetpack.filmsapp.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.databinding.ListItemsTvshowBinding
import com.arisurya.jetpack.filmsapp.ui.detail.DetailTvShowActivity
import com.bumptech.glide.Glide


class TvShowAdapter(private val callback: TvShowFragmentCallback) :
    RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {


    private var listShow = ArrayList<FilmEntity>()
    fun setTvShow(tvShow: List<FilmEntity>?) {
        if (tvShow == null) return
        this.listShow.clear()
        this.listShow.addAll(tvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val listItemsTvshowBinding =
            ListItemsTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(listItemsTvshowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listShow[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listShow.size


    inner class TvShowViewHolder(private val binding: ListItemsTvshowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: FilmEntity) {
            with(binding) {
                tvShowTitle.text = tvShow.title
                tvShowRating.text = tvShow.rating.toString()
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w185${tvShow.imagePath}")
                    .into(imgShowPoster)

                btnShare.setOnClickListener { callback.onShareClick(tvShow) }
                btnVisit.setOnClickListener { callback.onVisitClick(tvShow) }

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_TV, tvShow.filmId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}