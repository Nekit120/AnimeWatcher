package com.example.animewatcher.data.repository

import android.util.Log
import com.example.animewatcher.data.database.MainDatabase
import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.repository.FavoriteRepository
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(val database: MainDatabase) : FavoriteRepository {
    override suspend fun getAllAnimeFromDb(): List<AnimeApiItemModel> {
        val allAnimeFromDb = database.getCodeDao().getAnimeList()
        val animeList: MutableList<AnimeApiItemModel> = mutableListOf()
        for (x in allAnimeFromDb){
            animeList.add(AnimeApiItemModel(x))
        }
        return animeList
    }

}