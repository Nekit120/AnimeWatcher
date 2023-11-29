package com.example.animewatcher.data.API

import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiList
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeAPI {
    @GET("list")
    suspend fun getLastUpdatesAnime(
        @Query("token") toket: String = "секрет",
        @Query("types") types:String = "anime-serial,anime",
        @Query("with_episodes") withEpisodes: Boolean = true,
        @Query("with_material_data") withMaterialData: Boolean = true,
        @Query("limit") limit:Int = 20
    ) : AnimeApiList
}