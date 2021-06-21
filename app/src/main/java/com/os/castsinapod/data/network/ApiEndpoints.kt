package com.os.castsinapod.data.network

import retrofit2.http.GET

interface ApiEndpoints {
    @GET("")
    suspend fun getPodcasts()
}