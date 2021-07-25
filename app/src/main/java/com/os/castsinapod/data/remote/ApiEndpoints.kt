package com.os.castsinapod.data.remote

import com.os.castsinapod.domain.models.PodcastResponse
import com.os.castsinapod.domain.models.PodcastsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiEndpoints {
    @GET("/api/v2/search")
    suspend fun searchPodcasts(@Query("q") q: String): PodcastsResponse

    @GET("api/v2/podcasts/{id}")
    suspend fun getPodcast(@Path("id") id: String) : PodcastResponse
}