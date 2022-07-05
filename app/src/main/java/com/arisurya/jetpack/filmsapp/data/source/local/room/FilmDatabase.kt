package com.arisurya.jetpack.filmsapp.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arisurya.jetpack.filmsapp.data.source.local.entity.FilmEntity

@Database(entities = [FilmEntity::class], version = 1, exportSchema = false)
<<<<<<< HEAD
abstract class FilmDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao

    companion object {
        @Volatile
        private var INSTANCE: FilmDatabase? = null

        fun getInstance(context: Context): FilmDatabase =
            INSTANCE ?: synchronized(this) {
=======
abstract class FilmDatabase : RoomDatabase(){
    abstract fun filmDao():FilmDao

    companion object{
        @Volatile
        private var INSTANCE : FilmDatabase?=null

        fun getInstance(context: Context) : FilmDatabase =
            INSTANCE ?: synchronized(this){
>>>>>>> 5e9cab813dfbf4b381cafde50c218eba216acf8c
                Room.databaseBuilder(
                    context.applicationContext,
                    FilmDatabase::class.java,
                    "Film.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}