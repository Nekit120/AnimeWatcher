package com.example.animewatcher.domain.model.KodikApiModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AnimeApiList (
    val time: String,
    val total: Int,
    @SerializedName("prev_page")
    val prevPage: String?,
    @SerializedName("next_page")
    val nextPage: String?,
    val results: List<AnimeApiItemModel>
): Parcelable{

}