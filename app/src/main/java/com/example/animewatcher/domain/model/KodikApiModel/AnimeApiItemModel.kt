package com.example.animewatcher.domain.model.KodikApiModel

import android.os.Parcelable
import com.example.animewatcher.data.database.AnimeItemModelDTO
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AnimeApiItemModel(
    val id: String,
    val type: String,
    val link: String,
    val title: String,
    @SerializedName("title_orig")
    val titleOrig: String,
    val year: Int,
    val seasons:  Map<String, Season>?,
    @SerializedName("material_data")
    val materialData: MaterialData?,
    val screenshots: List<String>

): Parcelable{
    constructor(item: AnimeItemModelDTO): this(
        item.id,item.type,item.link,item.title,item.titleOrig,item.year
        ,item.seasons,item.materialData,item.screenshots
    )
}