package com.otienosamwel.data.repositories.podcastRepository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PodcastRepositoryModule {

    @Binds
    abstract fun bindPodcastRepository(podcastRepository: PodcastRepositoryImpl): PodcastRepository
}