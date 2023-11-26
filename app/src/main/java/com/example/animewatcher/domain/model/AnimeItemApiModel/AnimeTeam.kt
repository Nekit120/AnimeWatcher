package com.example.animewatcher.domain.model.AnimeItemApiModel

data class AnimeTeam(
    val voice: List<String>,
    val translator: List<String>,
    val editing: List<String>,
    val decor: List<String>,
    val timing: List<String>
)
