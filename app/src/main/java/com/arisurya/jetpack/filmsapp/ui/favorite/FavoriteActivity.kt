package com.arisurya.jetpack.filmsapp.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arisurya.jetpack.filmsapp.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)

        val favoriteSectionPagerAdapter = FavoriteSectionPagerAdapter(this, supportFragmentManager)
        activityFavoriteBinding.viewPager.adapter = favoriteSectionPagerAdapter
        activityFavoriteBinding.tabs.setupWithViewPager(activityFavoriteBinding.viewPager)
        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Favorite Films"
    }
}