package com.os.castsinapod.data.repository

import com.os.castsinapod.data.network.ApiEndpoints

class Repository(private val api : ApiEndpoints) {
        suspend fun getPodcasts(){
            api.getPodcasts()
        }
}