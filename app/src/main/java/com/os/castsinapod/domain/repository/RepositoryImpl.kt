package com.os.castsinapod.domain.repository

import com.os.castsinapod.data.remote.ApiEndpoints
import com.os.castsinapod.domain.models.PodcastResponse
import com.os.castsinapod.domain.models.PodcastsResponse
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api: ApiEndpoints) : Repository {
    override suspend fun getPodcasts(q: String): PodcastResponse {
        return api.searchPodcasts(q)
    }

    override suspend fun getPodcast(id: String): PodcastResponse {
        return api.getPodcast(id)
    }
}