package com.example.animewatcher.domain.model.KodikApiModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MaterialData (
    val title: String,
    @SerializedName("anime_title")
    val titleEn: String?,
    @SerializedName("anime_kind")
    val animeKind: String?,
    @SerializedName("all_status")
    val allStatus: String?,
    @SerializedName("anime_status")
    val animeStatus: String?,
    val description: String?,
    @SerializedName("poster_url")
    val posterUrl: String?,
    val duration: Int?,
    @SerializedName("all_genres")
    val allGenres: List<String>?,
    @SerializedName("anime_genres")
    val animeGenres: List<String>?,
    @SerializedName("shikimori_rating")
    val shikimoriRating: Double?,
    @SerializedName("aired_at")
    val airedAt: String?,
    @SerializedName("episodes_total")
    val episodesTotal: Int?,
    @SerializedName("episodes_aired")
    val episodesAired: Int?
): Parcelable{}