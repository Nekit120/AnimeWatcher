package com.example.animewatcher.data.repository

import android.util.Log
import com.example.animewatcher.data.API.AnimeAPI
import com.example.animewatcher.data.API.GetApiKeyClass
import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.repository.WatchRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.util.Properties
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class WatchRepositoryImpl @Inject constructor(val retrofit: Retrofit,val getApiKeyClass: GetApiKeyClass) : WatchRepository {

    override suspend fun getLastUpdateAnime (): List<AnimeApiItemModel> {
        val animeAPI = retrofit.create(AnimeAPI::class.java)
        val animeAPIList = animeAPI.getLastUpdatesAnime()
        return animeAPIList.results
    }


}