package com.arisurya.jetpack.filmsapp.ui.favorite.favtvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arisurya.jetpack.filmsapp.R
import com.arisurya.jetpack.filmsapp.databinding.FragmentFavoriteTvShowBinding
<<<<<<< HEAD
import com.arisurya.jetpack.filmsapp.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
=======
import com.arisurya.jetpack.filmsapp.ui.favorite.favmovie.FavoriteMovieAdapter
import com.arisurya.jetpack.filmsapp.ui.favorite.favmovie.FavoriteMovieViewModel
import com.arisurya.jetpack.filmsapp.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_favorite_movie.*
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c


class FavoriteTvShowFragment : Fragment() {

<<<<<<< HEAD
    private lateinit var fragmentFavoriteTvShowViewBinding: FragmentFavoriteTvShowBinding
    private lateinit var viewModel: FavoriteTvShowViewModel
    private lateinit var favTvShowAdapter: FavoriteTvShowAdapter
=======
    private lateinit var fragmentFavoriteTvShowViewBinding : FragmentFavoriteTvShowBinding
    private lateinit var viewModel: FavoriteTvShowViewModel
    private lateinit var favTvShowAdapter : FavoriteTvShowAdapter
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
<<<<<<< HEAD
    ): View {
        // Inflate the layout for this fragment
        fragmentFavoriteTvShowViewBinding =
            FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
=======
    ): View? {
        // Inflate the layout for this fragment
        fragmentFavoriteTvShowViewBinding = FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
        return fragmentFavoriteTvShowViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemTouchHelper.attachToRecyclerView(fragmentFavoriteTvShowViewBinding.rvFavTvShow)

<<<<<<< HEAD
        if (activity != null) {
=======
        if(activity!=null){
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(
                this,
                factory
            )[FavoriteTvShowViewModel::class.java]

            favTvShowAdapter = FavoriteTvShowAdapter()
            setProgressBar(true)
            viewModel.getFavoriteTvShow().observe(this, { favTvShow ->
<<<<<<< HEAD
                if (favTvShow != null) {
                    setProgressBar(false)
                    if (favTvShow.size == 0) setImageNoFavorite(true)
                    else setImageNoFavorite(false)
=======
                if (favTvShow!= null) {
                    setProgressBar(false)
                    if(favTvShow.size == 0) setImageNoData(true)
                    else setImageNoData(false)
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
                    favTvShowAdapter.submitList(favTvShow)
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

<<<<<<< HEAD
    private fun setImageNoFavorite(state: Boolean) {
        if (state) {
            fragmentFavoriteTvShowViewBinding.imgNoData.visibility = View.VISIBLE
            fragmentFavoriteTvShowViewBinding.tvEmpty.visibility = View.VISIBLE
        } else {
=======
    private fun setImageNoData(state: Boolean){
        if(state){
            fragmentFavoriteTvShowViewBinding.imgNoData.visibility = View.VISIBLE
            fragmentFavoriteTvShowViewBinding.tvEmpty.visibility = View.VISIBLE
        }
        else {
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
            fragmentFavoriteTvShowViewBinding.imgNoData.visibility = View.GONE
            fragmentFavoriteTvShowViewBinding.tvEmpty.visibility = View.GONE
        }
    }

<<<<<<< HEAD
    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
=======
    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback(){
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)


        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
<<<<<<< HEAD
            if (view != null) {
=======
            if(view!=null){
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
                val swipedPosition = viewHolder.adapterPosition
                val filmEntity = favTvShowAdapter.getSwipedData(swipedPosition)
                filmEntity?.let { viewModel.setFavorite(it) }

<<<<<<< HEAD
                val snackBar =
                    Snackbar.make(view as View, R.string.message_cancel, Snackbar.LENGTH_LONG)
                snackBar.setAction(R.string.message_confirm) {
=======
                val snackBar = Snackbar.make(view as View,R.string.message_cancel, Snackbar.LENGTH_LONG)
                snackBar.setAction(R.string.message_confirm){
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
                    filmEntity?.let { viewModel.setFavorite(it) }
                }
                snackBar.show()
            }
        }

    })

}