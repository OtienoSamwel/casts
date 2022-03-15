package com.otienosamwel.data.repositories.podcastRepository

import com.otienosamwel.data.models.PodcastsResponse
import com.otienosamwel.data.models.SinglePodcastResponse

interface PodcastRepository {
    suspend fun getPodcasts(q: String): PodcastsResponse
    suspend fun getPodcast(id: String): SinglePodcastResponse
}