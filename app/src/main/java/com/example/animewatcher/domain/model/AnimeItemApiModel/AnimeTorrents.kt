package com.example.animewatcher.domain.model.AnimeItemApiModel

data class AnimeTorrents(
    val episodes: AnimeEpisodeList,
    val list: List<AnimeTorrent>
)
