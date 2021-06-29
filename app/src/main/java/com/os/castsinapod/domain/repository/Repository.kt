package com.os.castsinapod.domain.repository

import com.os.castsinapod.domain.models.PodcastResponse
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


interface Repository {
    suspend fun getPodcasts(q: String): PodcastResponse
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryBinding {

    @Binds
    abstract fun provideRepository(repositoryImpl: RepositoryImpl): Repository
}