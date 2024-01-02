package com.example.animewatcher.data.repository

import com.example.animewatcher.data.API.AnimeAPI
import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.repository.SearchRepository
import retrofit2.Retrofit

class SearchRepositoryImpl(val retrofit: Retrofit):SearchRepository {
    override suspend fun getSearchAnime(animeTitleName: String): List<AnimeApiItemModel> {
        val animeApi = retrofit.create(AnimeAPI::class.java)
        val animeSearchList = animeApi.getSearchAnime(title = animeTitleName)
        return animeSearchList.results

    }


}