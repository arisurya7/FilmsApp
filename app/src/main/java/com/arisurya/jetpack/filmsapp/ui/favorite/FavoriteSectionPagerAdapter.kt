package com.arisurya.jetpack.filmsapp.ui.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.arisurya.jetpack.filmsapp.R
import com.arisurya.jetpack.filmsapp.ui.favorite.favmovie.FavoriteMovieFragment
import com.arisurya.jetpack.filmsapp.ui.favorite.favtvshow.FavoriteTvShowFragment
<<<<<<< HEAD


class FavoriteSectionPagerAdapter(private val mContext: Context, fm: FragmentManager) :
=======
import com.arisurya.jetpack.filmsapp.ui.movie.MoviesFragment
import com.arisurya.jetpack.filmsapp.ui.tvshow.TvShowFragment

class FavoriteSectionPagerAdapter (private val mContext: Context, fm: FragmentManager) :
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tv_Show)
    }

    override fun getCount(): Int = TAB_TITLES.size

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FavoriteMovieFragment()
            1 -> FavoriteTvShowFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence =
        mContext.resources.getString(TAB_TITLES[position])
}