package com.example.animewatcher.domain.usecase

import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.repository.AnimeInfoRepository

class AnimeInfoUseCase(val animeInfoRepository: AnimeInfoRepository) {
    suspend fun addAnimeItemInDb(animeItem:AnimeApiItemModel){
        animeInfoRepository.addAnimeItemInDb(animeItem)
    }

    suspend fun matchСheckingAnimeItem(animeId: String): Boolean {
       return animeInfoRepository.matchСheckingAnimeItem(animeId)
    }

    suspend fun deleteAnimeItemFromDb (animeItem:AnimeApiItemModel) {
        animeInfoRepository.deleteAnimeItemFromDb(animeItem)
    }
}