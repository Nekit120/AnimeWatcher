package com.example.animewatcher.data.repository

import android.util.Log
import com.example.animewatcher.data.database.AnimeItemModelDTO
import com.example.animewatcher.data.database.MainDatabase
import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.repository.AnimeInfoRepository
import com.example.animewatcher.domain.repository.FavoriteRepository
import javax.inject.Inject

class AnimeInfoRepositoryImpl @Inject constructor(val database: MainDatabase) : AnimeInfoRepository {
    override suspend fun addAnimeItemInDb(animeItem: AnimeApiItemModel) {
        val animeDao = database.getCodeDao()
        animeDao.insertAnimeItem(AnimeItemModelDTO(animeItem))
    }
}