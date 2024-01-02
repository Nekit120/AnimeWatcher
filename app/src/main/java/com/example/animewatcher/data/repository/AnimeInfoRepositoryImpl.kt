package com.example.animewatcher.data.repository

import android.util.Log
import com.example.animewatcher.data.database.AnimeItemModelDTO
import com.example.animewatcher.data.database.MainDatabase
import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.repository.AnimeInfoRepository
import com.example.animewatcher.domain.repository.FavoriteRepository
import javax.inject.Inject

class AnimeInfoRepositoryImpl (val database: MainDatabase) : AnimeInfoRepository {
    override suspend fun addAnimeItemInDb(animeItem: AnimeApiItemModel) {
        val animeDao = database.getCodeDao()
        animeDao.insertAnimeItem(AnimeItemModelDTO(animeItem))
    }

    override suspend fun deleteAnimeItemFromDb(animeItem: AnimeApiItemModel) {
        val animeDao = database.getCodeDao()
        animeDao.deleteAnimeItem(AnimeItemModelDTO(animeItem))
    }

    override suspend fun matchСheckingAnimeItem(id: String): Boolean {
        val animeDao = database.getCodeDao()
        val animeList = animeDao.getAnimeList()
        var resultChecking = false
        for( animeItem in animeList){
            if (animeItem.id == id) {
                resultChecking = true
            }
        }
     return resultChecking
    }
}