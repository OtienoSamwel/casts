package com.otienosamwel.data.repositories.podcastRepository

import com.otienosamwel.data.models.PodcastsResponse
import com.otienosamwel.data.models.SinglePodcastResponse
import com.otienosamwel.data.remote.PodcastNetworkService
import javax.inject.Inject

class PodcastRepositoryImpl @Inject constructor(private val podcastService: PodcastNetworkService) :
    PodcastRepository {
    override suspend fun getPodcasts(q: String): PodcastsResponse {
        return podcastService.searchPodcasts(q)
    }

    override suspend fun getPodcast(id: String): SinglePodcastResponse {
        return podcastService.getSinglePodCast(id)
    }
}