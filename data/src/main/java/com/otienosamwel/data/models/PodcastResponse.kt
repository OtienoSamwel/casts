package com.otienosamwel.data.models

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "podcast_response")
data class PodcastsResponse(
    val count: Int?,
    val next_offset: Int?,
    val results: List<Result>,
    val took: Double,
    val total: Int?
)

data class Result(
    val audio: String?,
    val audio_length_sec: Int?,
    val description_highlighted: String?,
    val description_original: String?,
    val explicit_content: Boolean,
    val guid_from_rss: String?,
    val id: String?,
    val image: String?,
    val itunes_id: Int?,
    val link: String?,
    @SerializedName("listennotes_url") val listenNotesUrl: String?,
    val podcast: Podcast,
    val pub_date_ms: Long,
    val rss: String?,
    val thumbnail: String?,
    val title_highlighted: String?,
    val title_original: String?,
    val transcripts_highlighted: List< Any?>
)

data class Podcast(
    val genre_ids: List<Int?>,
    val id: String?,
    val image: String?,
    val listen_score: Int?,
    val listen_score_global_rank: String?,
    @SerializedName("listennotes_url") val listenNotesUrl: String?,
    val publisher_highlighted: String?,
    val publisher_original: String?,
    val thumbnail: String?,
    val title_highlighted: String?,
    val title_original: String?
)
