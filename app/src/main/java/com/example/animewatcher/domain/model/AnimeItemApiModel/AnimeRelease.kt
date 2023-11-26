package com.example.animewatcher.domain.model.AnimeItemApiModel

data class AnimeRelease(
    val id: Int,
    val code: String,
    val ordinal: Int,
    val names: AnimeNames
)
