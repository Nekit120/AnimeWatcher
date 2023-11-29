package com.example.animewatcher.domain.model.KodikApiModel

import com.google.gson.annotations.SerializedName

data class AnimeApiList (
    val time: String,
    val total: Int,
    @SerializedName("prev_page")
    val prevPage: String?,
    @SerializedName("next_page")
    val nextPage: String?,
    val results: List<AnimeApiItemModel>
)