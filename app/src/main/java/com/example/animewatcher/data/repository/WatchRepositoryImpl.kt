package com.example.animewatcher.data.repository

import com.example.animewatcher.data.API.AnimeAPI
import com.example.animewatcher.data.database.AnimeItemModelDTO
import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.repository.WatchRepository
import com.example.animewatcher.presentation.App
import retrofit2.Retrofit
import javax.inject.Inject

class WatchRepositoryImpl @Inject constructor(val retrofit: Retrofit) : WatchRepository {

    override suspend fun getLastUpdateAnime (): List<AnimeApiItemModel> {
        val animeAPI = retrofit.create(AnimeAPI::class.java)
        val dao = App.database.getCodeDao()
        val animeAPIList = animeAPI.getLastUpdatesAnime()
        return animeAPIList.results
    }


}