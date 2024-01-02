package com.example.animewatcher.domain.repository

import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel

interface SearchRepository {
    suspend fun getSearchAnime (animeTitleName: String) : List<AnimeApiItemModel>
}