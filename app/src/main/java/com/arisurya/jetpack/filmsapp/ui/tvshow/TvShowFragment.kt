package com.arisurya.jetpack.filmsapp.ui.tvshow

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arisurya.jetpack.filmsapp.R
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity
import com.arisurya.jetpack.filmsapp.databinding.FragmentTvShowBinding
import com.arisurya.jetpack.filmsapp.viewmodel.ViewModelFactory


class TvShowFragment : Fragment(), TvShowFragmentCallback {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding
    private lateinit var viewModel: TvShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(
                this,
                factory
            )[TvShowViewModel::class.java]
            setViewModelTvShow()
        }
    }

    override fun onShareClick(tvShow: FilmEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Share via")
                .setText(tvShow.link)
                .startChooser()
        }
    }

    override fun onVisitClick(tvShow: FilmEntity) {
        if (activity != null) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(tvShow.link)))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_show, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.sort_default -> {
//                viewModel.setOptionShow(0)
//                setViewModelTvShow()
//            }
//
//            R.id.sort_rating -> {
//                viewModel.setOptionShow(1)
//                setViewModelTvShow()
//            }
//
//            R.id.sort_title -> {
//                viewModel.setOptionShow(2)
//                setViewModelTvShow()
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }

    private fun setViewModelTvShow() {

        val tvShowAdapter = TvShowAdapter(this)
        setProgressBar(true)
        viewModel.getTvShowOptions(viewModel.choose).observe(this, { tvShow ->
            setProgressBar(false)
            tvShowAdapter.setTvShow(tvShow)
            tvShowAdapter.notifyDataSetChanged()
        })

        with(fragmentTvShowBinding.rvTvshow) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tvShowAdapter
        }
    }

    private fun setProgressBar(state: Boolean) {
        if (state) fragmentTvShowBinding.progressBar.visibility = View.VISIBLE
        else fragmentTvShowBinding.progressBar.visibility = View.GONE
    }
}