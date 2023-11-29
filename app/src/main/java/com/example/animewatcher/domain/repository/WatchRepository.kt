package com.example.animewatcher.domain.repository

import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel

interface WatchRepository {

    suspend fun getLastUpdateAnime () : List<AnimeApiItemModel>
}