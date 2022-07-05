package com.arisurya.jetpack.filmsapp.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arisurya.jetpack.filmsapp.R
import com.arisurya.jetpack.filmsapp.databinding.FragmentMoviesBinding
import com.arisurya.jetpack.filmsapp.ui.favorite.FavoriteActivity
import com.arisurya.jetpack.filmsapp.viewmodel.ViewModelFactory
import com.arisurya.jetpack.filmsapp.vo.Status


class MoviesFragment : Fragment() {

    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding
    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(
                this,
                factory
            )[MoviesViewModel::class.java]
            setViewModelMovie()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_movie, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.sort_default -> {
                viewModel.setOption(0)
                setViewModelMovie()
            }
            R.id.sort_rating -> {
                viewModel.setOption(1)
                setViewModelMovie()
            }
            R.id.sort_title -> {
                viewModel.setOption(2)
                setViewModelMovie()
            }
<<<<<<< HEAD
            R.id.fav -> {
                startActivity(Intent(activity, FavoriteActivity::class.java))
=======
            R.id.fav->{
                startActivity(Intent (activity, FavoriteActivity::class.java))
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
            }
        }

        return super.onOptionsItemSelected(item)

    }

    private fun setViewModelMovie() {
        val moviesAdapter = MoviesAdapter()
        setProgressBar(true)
        viewModel.getMovieOptions(viewModel.choose).observe(viewLifecycleOwner, { movies ->
            if (movies != null) {
                when (movies.status) {
                    Status.LOADING -> setProgressBar(true)
                    Status.SUCCESS -> {
                        setProgressBar(false)
                        moviesAdapter.submitList(movies.data)
                    }
                    Status.ERROR -> {
                        setProgressBar(false)
<<<<<<< HEAD
                        Toast.makeText(context, "Something Wrong", Toast.LENGTH_SHORT).show()
=======
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
                    }
                }
            }
        })


        with(fragmentMoviesBinding.rvMovies) {
            this.layoutManager = LinearLayoutManager(context)
            this.setHasFixedSize(true)
            this.adapter = moviesAdapter
        }
    }

    private fun setProgressBar(state: Boolean) {
        if (state) fragmentMoviesBinding.progressBar.visibility = View.VISIBLE
        else fragmentMoviesBinding.progressBar.visibility = View.GONE
    }


}