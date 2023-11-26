package com.example.animewatcher.domain.model.AnimeItemApiModel

data class AnimeTorrent(
    val torrentId: Int,
    val episodes: AnimeEpisodeList,
    val quality: AnimeQuality,
    val leechers: Int,
    val seeders: Int,
    val downloads: Int,
    val totalSize: Long,
    val sizeString: String,
    val url: String,
    val magnet: String,
    val uploadedTimestamp: Long,
    val hash: String,
    val metadata: String?,
    val rawBase64File: String?
)