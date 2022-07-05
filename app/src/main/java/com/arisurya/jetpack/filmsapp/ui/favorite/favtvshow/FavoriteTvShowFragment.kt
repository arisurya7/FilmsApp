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
import com.arisurya.jetpack.filmsapp.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar


class FavoriteTvShowFragment : Fragment() {

    private lateinit var fragmentFavoriteTvShowViewBinding: FragmentFavoriteTvShowBinding
    private lateinit var viewModel: FavoriteTvShowViewModel
    private lateinit var favTvShowAdapter: FavoriteTvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentFavoriteTvShowViewBinding =
            FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteTvShowViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemTouchHelper.attachToRecyclerView(fragmentFavoriteTvShowViewBinding.rvFavTvShow)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(
                this,
                factory
            )[FavoriteTvShowViewModel::class.java]

            favTvShowAdapter = FavoriteTvShowAdapter()
            setProgressBar(true)
            viewModel.getFavoriteTvShow().observe(this, { favTvShow ->
                if (favTvShow != null) {
                    setProgressBar(false)
                    if (favTvShow.size == 0) setImageNoFavorite(true)
                    else setImageNoFavorite(false)
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

    private fun setImageNoFavorite(state: Boolean) {
        if (state) {
            fragmentFavoriteTvShowViewBinding.imgNoData.visibility = View.VISIBLE
            fragmentFavoriteTvShowViewBinding.tvEmpty.visibility = View.VISIBLE
        } else {
            fragmentFavoriteTvShowViewBinding.imgNoData.visibility = View.GONE
            fragmentFavoriteTvShowViewBinding.tvEmpty.visibility = View.GONE
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
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
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val filmEntity = favTvShowAdapter.getSwipedData(swipedPosition)
                filmEntity?.let { viewModel.setFavorite(it) }

                val snackBar =
                    Snackbar.make(view as View, R.string.message_cancel, Snackbar.LENGTH_LONG)
                snackBar.setAction(R.string.message_confirm) {
                    filmEntity?.let { viewModel.setFavorite(it) }
                }
                snackBar.show()
            }
        }

    })

}