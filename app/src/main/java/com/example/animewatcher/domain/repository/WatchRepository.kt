package com.example.animewatcher.domain.repository

import com.example.animewatcher.domain.model.AnimeItemApiModel.AnimeApiItemModel

interface WatchRepository {

    suspend fun getLastUpdateAnime () : List<AnimeApiItemModel>
}