package com.example.animewatcher.domain.model.AnimeItemApiModel

data class AnimePlayer(
    val alternativePlayer: String?,
    val host: String,
    val isRutube: Boolean,
    val episodes: AnimeEpisodeList
)
