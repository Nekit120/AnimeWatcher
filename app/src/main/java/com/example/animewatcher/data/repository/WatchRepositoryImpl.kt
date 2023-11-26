package com.example.animewatcher.data.repository

import android.util.Log
import com.example.animewatcher.data.API.AnimeAPI
import com.example.animewatcher.domain.model.AnimeItemApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.repository.WatchRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class WatchRepositoryImpl : WatchRepository {
    val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS) // Увеличиваем таймаут на установление соединения до 30 секунд
        .readTimeout(30, TimeUnit.SECONDS)    // Увеличиваем таймаут на чтение данных до 30 секунд
        .writeTimeout(30, TimeUnit.SECONDS)   // Увеличиваем таймаут на запись данных до 30 секунд
        .build()

    override suspend fun getLastUpdateAnime(): List<AnimeApiItemModel> {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.anilibria.tv/v3/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val animeAPI = retrofit.create(AnimeAPI::class.java)
        val animeAPIList = animeAPI.getLastUpdatesAnime()
        return animeAPIList.list
    }

}