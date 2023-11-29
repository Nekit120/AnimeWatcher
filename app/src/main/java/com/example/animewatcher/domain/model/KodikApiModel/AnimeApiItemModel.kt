package com.example.animewatcher.domain.model.KodikApiModel

import com.google.gson.annotations.SerializedName

data class AnimeApiItemModel(
    val id: String,
    val type: String,
    val link: String,
    val title: String,
    @SerializedName("title_orig")
    val titleOrig: String,
    @SerializedName("other_title")
    val otherTitle: String,
    val translation: Translation,
    val year: Int,
    @SerializedName("last_season")
    val lastSeason: Int,
    @SerializedName("last_episode")
    val lastEpisode: Int,
    @SerializedName("episodes_count")
    val episodesCount: Int,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("worldart_link")
    val worldartLink: String,
    @SerializedName("shikimori_id")
    val shikimoriId: String,
    val quality: String,
    val camrip: Boolean,
    val lgbt: Boolean,
    @SerializedName("blocked_countries")
    val blockedCountries: List<String>,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    val seasons:  Map<String, Season>,
    @SerializedName("material_data")
    val materialData: MaterialData,
    val screenshots: List<String>

)