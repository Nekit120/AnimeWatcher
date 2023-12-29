package com.example.animewatcher.domain.repository

import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel

interface FavoriteRepository {
    suspend fun getAllAnimeFromDb () : List<AnimeApiItemModel>
}