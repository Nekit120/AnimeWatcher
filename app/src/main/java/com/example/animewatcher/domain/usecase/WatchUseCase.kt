package com.example.animewatcher.domain.usecase

import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.repository.WatchRepository

class WatchUseCase(val watchRepository: WatchRepository ) {

    suspend fun getLastUpdatesAnimeList(): List<AnimeApiItemModel> {
        return watchRepository.getLastUpdateAnime()
    }

}