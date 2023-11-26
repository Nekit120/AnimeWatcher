package com.example.animewatcher.domain.model.AnimeItemApiModel

data class AnimeQuality(
    val string: String,
    val type: String,
    val resolution: String,
    val encoder: String,
    val lqAudio: String?
)
