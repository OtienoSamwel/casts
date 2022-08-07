package com.otienosamwel.data.remote

import com.otienosamwel.data.models.PodcastsResponse
import com.otienosamwel.data.models.SinglePodcastResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class PodcastService @Inject constructor(private val client: HttpClient) {

    suspend fun searchPodcasts(query: String): PodcastsResponse {
        return client.get("/api/v2/search") {
            parameter("q", query)
        }.body()
    }

    suspend fun getSinglePodCast(id: String): SinglePodcastResponse {
        return client.get("api/v2/podcasts/$id").body()
    }
}