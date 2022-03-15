package com.otienosamwel.data.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PodcastsResponse(
    val count: Int?,
    val next_offset: Int?,
    val results: List<Result>,
    val took: Double,
    val total: Int?
)

@Serializable
data class Result(
    val audio: String?,
    val audio_length_sec: Int?,
    val description_highlighted: String?,
    val description_original: String?,
    val explicit_content: Boolean?,
    val guid_from_rss: String?,
    val id: String?,
    val image: String?,
    val itunes_id: Int?,
    val link: String?,
    @SerialName("listennotes_url") val listenNotesUrl: String?,
    val podcast: Podcast,
    val pub_date_ms: Long,
    val rss: String?,
    val thumbnail: String?,
    val title_highlighted: String?,
    val title_original: String?,
    val transcripts_highlighted: List<@Contextual Any?>
)

@Serializable
data class Podcast(
    val genre_ids: List<Int?>,
    val id: String?,
    val image: String?,
    val listen_score: Int?,
    val listen_score_global_rank: String?,
    @SerialName("listennotes_url") val listenNotesUrl: String?,
    val publisher_highlighted: String?,
    val publisher_original: String?,
    val thumbnail: String?,
    val title_highlighted: String?,
    val title_original: String?
)
