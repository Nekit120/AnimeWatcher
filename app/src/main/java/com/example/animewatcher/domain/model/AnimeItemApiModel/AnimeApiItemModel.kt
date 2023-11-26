package com.example.animewatcher.domain.model.AnimeItemApiModel

data class AnimeApiItemModel(
    val id: Int,
    val code: String,
    val names: AnimeNames,
//    val franchises: List<AnimeFranchise>,
//    val announce: String?,
//    val status: AnimeStatus,
    val posters: AnimePosters,
//    val updated: Long,
//    val lastChange: Long,
//   val type: AnimeType,
//   val genres: List<String>,
//    val team: AnimeTeam,
//    val season: AnimeSeason,
//    val description: String,
//    val inFavorites: Int,
//    val blocked: AnimeBlocked,
//    val player: AnimePlayer,
//    val torrents: AnimeTorrents

)