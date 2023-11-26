package com.example.animewatcher.domain.model.AnimeItemApiModel

data class AnimeType(
    val fullString: String,
    val code: Int,
    val string: String,
    val episodes: Int,
    val length: Int?
)
