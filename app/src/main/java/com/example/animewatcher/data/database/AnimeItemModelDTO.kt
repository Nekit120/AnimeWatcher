package com.example.animewatcher.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.animewatcher.domain.model.KodikApiModel.AnimeApiItemModel
import com.example.animewatcher.domain.model.KodikApiModel.MaterialData
import com.example.animewatcher.domain.model.KodikApiModel.Season

@Entity(tableName = "AnimeInfo")
data class AnimeItemModelDTO(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @ColumnInfo("type")
    val type: String,
    @ColumnInfo("link")
    val link: String,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("titleOrig")
    val titleOrig: String,
    @ColumnInfo("year")
    val year: Int,
    @ColumnInfo("lastSeason")
    val lastSeason: Int,
    @ColumnInfo("lastEpisode")
    val lastEpisode: Int,
    @ColumnInfo("episodesCount")
    val episodesCount: Int,
    @ColumnInfo("seasons")
    val seasons:  Map<String, Season>,
    @ColumnInfo("materialData")
    val materialData: MaterialData?,
    @ColumnInfo("screenshots")
    val screenshots: List<String>

) {
    constructor(item: AnimeApiItemModel): this(
        item.id,item.type,item.link,item.title,item.titleOrig,item.year, item.lastSeason,
        item.lastEpisode,item.episodesCount,item.seasons,item.materialData,item.screenshots
    )
}