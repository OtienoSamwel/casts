package com.otienosamwel.data.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.gson.*

@Module
@InstallIn(SingletonComponent::class)
object NetworkClient {

    private const val BASE_URL = "listen-api-test.listennotes.com"

    private val client = HttpClient(CIO) {

        defaultRequest {
            host = BASE_URL
            contentType(ContentType.Application.Json)
        }

        install(ContentNegotiation) {

            gson {
                setLenient()
                setPrettyPrinting()
                serializeNulls()
            }
        }

        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.ALL
        }
    }

    @Provides
    fun provideClient(): HttpClient = client
}