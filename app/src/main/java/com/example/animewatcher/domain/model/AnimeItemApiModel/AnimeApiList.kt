package com.example.animewatcher.domain.model.AnimeItemApiModel

import com.google.gson.annotations.SerializedName

data class AnimeApiList (
    val list: List<AnimeApiItemModel>
)