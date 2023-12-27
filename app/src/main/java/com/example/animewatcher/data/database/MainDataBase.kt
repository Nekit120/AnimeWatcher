package com.example.animewatcher.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [AnimeItemModelDTO::class], exportSchema = false, version = 1)
@TypeConverters(Converters::class)
abstract class MainDatabase : RoomDatabase() {
    abstract fun getCodeDao(): AnimeDao

    companion object {
        @Volatile
        private var INSTANCE: MainDatabase? = null

        fun getDatabase(context: Context): MainDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "AnimeItemList.db"
                ).fallbackToDestructiveMigration()
                    .allowMainThreadQueries().build()
                instance
            }
        }
    }
}