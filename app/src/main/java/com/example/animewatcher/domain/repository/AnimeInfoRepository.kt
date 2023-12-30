package com.example.animewatcher.domain.repository

import android.content.ClipData.Item
import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel

interface AnimeInfoRepository {
    suspend fun addAnimeItemInDb (animeItem:AnimeApiItemModel)
}