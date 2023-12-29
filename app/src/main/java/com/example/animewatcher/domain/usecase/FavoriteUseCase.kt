package com.example.animewatcher.domain.usecase

import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.repository.FavoriteRepository
import com.example.animewatcher.domain.repository.WatchRepository

class FavoriteUseCase(val favoriteRepository: FavoriteRepository ) {

    suspend fun getAllAnimeFromDb(): List<AnimeApiItemModel> {
        return favoriteRepository.getAllAnimeFromDb()
    }

}