package com.example.animewatcher.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AnimeDao {
    @Query("SELECT * FROM AnimeInfo")
    fun getAnimeList(): List<AnimeItemModelDTO>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAnimeItem(itemDTO: AnimeItemModelDTO)
    @Delete
    fun deleteAnimeItem(itemDTO: AnimeItemModelDTO)
}