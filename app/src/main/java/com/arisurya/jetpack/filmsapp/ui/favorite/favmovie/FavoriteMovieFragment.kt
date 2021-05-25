package com.arisurya.jetpack.filmsapp.ui.favorite.favmovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arisurya.jetpack.filmsapp.R
import com.arisurya.jetpack.filmsapp.databinding.FragmentFavoriteMovieBinding
import com.arisurya.jetpack.filmsapp.ui.movie.MoviesAdapter
import com.arisurya.jetpack.filmsapp.ui.movie.MoviesViewModel
import com.arisurya.jetpack.filmsapp.viewmodel.ViewModelFactory
import com.arisurya.jetpack.filmsapp.vo.Status


class FavoriteMovieFragment : Fragment() {

    private lateinit var fragmentFavoriteViewBinding: FragmentFavoriteMovieBinding
    private lateinit var viewModel: FavoriteMovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentFavoriteViewBinding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container,false)
        return fragmentFavoriteViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity!=null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(
                this,
                factory
            )[FavoriteMovieViewModel::class.java]

            val favMoviesAdapter = FavoriteMovieAdapter()
            setProgressBar(true)
            viewModel.getFavoriteMovies().observe(this, { favMovies ->
                if (favMovies != null) {
                    setProgressBar(false)
                    favMoviesAdapter.setFavoriteMovies(favMovies)
                    favMoviesAdapter.notifyDataSetChanged()
                }
            })

            with(fragmentFavoriteViewBinding.rvFavMovies) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = favMoviesAdapter
            }
        }
    }


    private fun setProgressBar(state: Boolean) {
        if (state) fragmentFavoriteViewBinding.progressBar.visibility = View.VISIBLE
        else fragmentFavoriteViewBinding.progressBar.visibility = View.GONE
    }


}