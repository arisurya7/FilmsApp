package com.arisurya.jetpack.filmsapp.ui.favorite.favtvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arisurya.jetpack.filmsapp.R
import com.arisurya.jetpack.filmsapp.databinding.FragmentFavoriteTvShowBinding
import com.arisurya.jetpack.filmsapp.ui.favorite.favmovie.FavoriteMovieAdapter
import com.arisurya.jetpack.filmsapp.ui.favorite.favmovie.FavoriteMovieViewModel
import com.arisurya.jetpack.filmsapp.viewmodel.ViewModelFactory


class FavoriteTvShowFragment : Fragment() {

    private lateinit var fragmentFavoriteTvShowViewBinding : FragmentFavoriteTvShowBinding
    private lateinit var viewModel: FavoriteTvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentFavoriteTvShowViewBinding = FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteTvShowViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity!=null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(
                this,
                factory
            )[FavoriteTvShowViewModel::class.java]

            val favTvShowAdapter = FavoriteTvShowAdapter()
            setProgressBar(true)
            viewModel.getFavoriteTvShow().observe(this, { favTvShow ->
                if (favTvShow!= null) {
                    setProgressBar(false)
                    favTvShowAdapter.setFavoriteTvShow(favTvShow)
                    favTvShowAdapter.notifyDataSetChanged()
                }
            })

            with(fragmentFavoriteTvShowViewBinding.rvFavTvShow) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = favTvShowAdapter
            }
        }

    }


    private fun setProgressBar(state: Boolean) {
        if (state) fragmentFavoriteTvShowViewBinding.progressBar.visibility = View.VISIBLE
        else fragmentFavoriteTvShowViewBinding.progressBar.visibility = View.GONE
    }

}