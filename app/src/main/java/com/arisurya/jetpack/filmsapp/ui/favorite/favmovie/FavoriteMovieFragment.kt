package com.arisurya.jetpack.filmsapp.ui.favorite.favmovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD
=======
import android.widget.Toast
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arisurya.jetpack.filmsapp.R
import com.arisurya.jetpack.filmsapp.databinding.FragmentFavoriteMovieBinding
<<<<<<< HEAD
import com.arisurya.jetpack.filmsapp.viewmodel.ViewModelFactory
=======
import com.arisurya.jetpack.filmsapp.ui.movie.MoviesAdapter
import com.arisurya.jetpack.filmsapp.ui.movie.MoviesViewModel
import com.arisurya.jetpack.filmsapp.viewmodel.ViewModelFactory
import com.arisurya.jetpack.filmsapp.vo.Status
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
import com.google.android.material.snackbar.Snackbar


class FavoriteMovieFragment : Fragment() {

    private lateinit var fragmentFavoriteViewBinding: FragmentFavoriteMovieBinding
    private lateinit var viewModel: FavoriteMovieViewModel
    private lateinit var favoriteMoviesAdapter: FavoriteMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
<<<<<<< HEAD
    ): View {
        // Inflate the layout for this fragment
        fragmentFavoriteViewBinding =
            FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
=======
    ): View? {
        // Inflate the layout for this fragment
        fragmentFavoriteViewBinding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container,false)
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
        return fragmentFavoriteViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemTouchHelper.attachToRecyclerView(fragmentFavoriteViewBinding.rvFavMovies)

<<<<<<< HEAD
        if (activity != null) {
=======
        if(activity!=null){
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(
                this,
                factory
            )[FavoriteMovieViewModel::class.java]

            favoriteMoviesAdapter = FavoriteMovieAdapter()
            setProgressBar(true)
            viewModel.getFavoriteMovies().observe(this, { favMovies ->
                if (favMovies != null) {
                    setProgressBar(false)
<<<<<<< HEAD
                    if (favMovies.size == 0) setImageNoFavorite(true)
                    else setImageNoFavorite(false)
=======
                    if(favMovies.size == 0) setImageNoData(true)
                    else setImageNoData(false)
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
                    favoriteMoviesAdapter.submitList(favMovies)
                }
            })

            with(fragmentFavoriteViewBinding.rvFavMovies) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = favoriteMoviesAdapter
            }
        }
    }


    private fun setProgressBar(state: Boolean) {
        if (state) fragmentFavoriteViewBinding.progressBar.visibility = View.VISIBLE
        else fragmentFavoriteViewBinding.progressBar.visibility = View.GONE
    }

<<<<<<< HEAD
    private fun setImageNoFavorite(state: Boolean) {
        if (state) {
            fragmentFavoriteViewBinding.imgNoData.visibility = View.VISIBLE
            fragmentFavoriteViewBinding.tvEmpty.visibility = View.VISIBLE
        } else {
=======
    private fun setImageNoData(state: Boolean){
        if(state){
            fragmentFavoriteViewBinding.imgNoData.visibility = View.VISIBLE
            fragmentFavoriteViewBinding.tvEmpty.visibility = View.VISIBLE
        }
        else {
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
            fragmentFavoriteViewBinding.imgNoData.visibility = View.GONE
            fragmentFavoriteViewBinding.tvEmpty.visibility = View.GONE
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
                val filmEntity = favoriteMoviesAdapter.getSwipedData(swipedPosition)
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