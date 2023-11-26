package com.example.animewatcher.domain.model.AnimeItemApiModel

data class AnimeFranchise(
    val franchise: AnimeFranchiseInfo,
    val releases: List<AnimeRelease>
)
