package com.otienosamwel.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SinglePodcastResponse(
    val country: String,
    val description: String,
    val earliest_pub_date_ms: Long,
    val email: String,
    val episodes: List<Episode>,
    val explicit_content: Boolean,
    val extra: Extra,
    val genre_ids: List<Int>,
    val id: String,
    val image: String,
    val is_claimed: Boolean,
    val itunes_id: Int,
    val language: String,
    val latest_pub_date_ms: Long,
    val listen_score: Int,
    val listen_score_global_rank: String,
    @SerialName("listennotes_url") val listenNotesUrl: String,
    val looking_for: LookingFor,
    val next_episode_pub_date: Long,
    val publisher: String,
    val rss: String,
    val thumbnail: String,
    val title: String,
    val total_episodes: Int,
    val type: String,
    val website: String
)

@Serializable
data class Episode(
    val audio: String,
    val audio_length_sec: Int,
    val description: String,
    val explicit_content: Boolean,
    val id: String,
    val image: String,
    val link: String,
    val listennotes_edit_url: String,
    val listennotes_url: String,
    val maybe_audio_invalid: Boolean,
    val pub_date_ms: Long,
    val thumbnail: String,
    val title: String
)

@Serializable
data class Extra(
    val facebook_handle: String,
    val google_url: String,
    val instagram_handle: String,
    val linkedin_url: String,
    val patreon_handle: String,
    val spotify_url: String,
    val twitter_handle: String,
    val url1: String,
    val url2: String,
    val url3: String,
    val wechat_handle: String,
    val youtube_url: String
)

@Serializable
data class LookingFor(
    val cohosts: Boolean,
    val cross_promotion: Boolean,
    val guests: Boolean,
    val sponsors: Boolean
)
