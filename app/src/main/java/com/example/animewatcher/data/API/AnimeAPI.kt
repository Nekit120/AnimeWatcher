package com.example.animewatcher.data.API

import com.example.animewatcher.domain.model.AnimeItemApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.model.AnimeItemApiModel.AnimeApiList
import retrofit2.http.GET

interface AnimeAPI {
    @GET("title/updates?limit=20")
    suspend fun getLastUpdatesAnime() : AnimeApiList
}