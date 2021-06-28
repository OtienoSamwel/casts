package com.os.castsinapod.data.remote

import com.os.castsinapod.domain.models.PodcastResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndpoints {
    @GET("/api/v2/search")
    suspend fun searchPodcasts(@Query("q") q: String): Flow<PodcastResponse>
}