package com.example.animewatcher.domain.model.KodikApiModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MaterialData (
    val title: String,
    @SerializedName("anime_title")
    val animeTitle: String,
    @SerializedName("title_en")
    val titleEn: String,
    @SerializedName("anime_kind")
    val animeKind: String,
    @SerializedName("all_status")
    val allStatus: String,
    @SerializedName("anime_status")
    val animeStatus: String,
    val description: String?,
    @SerializedName("poster_url")
    val posterUrl: String,
    val screenshots: List<String>,
    val duration: Int,
    @SerializedName("all_genres")
    val allGenres: List<String>,
    @SerializedName("anime_genres")
    val animeGenres: List<String>,
    @SerializedName("anime_studios")
    val animeStudios: List<String>,
    @SerializedName("shikimori_rating")
    val shikimoriRating: Double,
    @SerializedName("shikimori_votes")
    val shikimoriVotes: Int,
    @SerializedName("aired_at")
    val airedAt: String,
    @SerializedName("rating_mpaa")
    val ratingMpaa: String,
    @SerializedName("episodes_total")
    val episodesTotal: Int,
    @SerializedName("episodes_aired")
    val episodesAired: Int
): Parcelable{}