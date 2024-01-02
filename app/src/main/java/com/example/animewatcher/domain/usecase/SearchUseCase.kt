package com.example.animewatcher.domain.usecase

import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.repository.SearchRepository

class SearchUseCase(val searchRepository: SearchRepository) {
    suspend fun getSearchAnime(animeTitleName:String): List<AnimeApiItemModel> {
        return searchRepository.getSearchAnime(animeTitleName)
    }
}