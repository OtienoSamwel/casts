package com.os.casts.ui.utils

import android.content.Context
import com.google.android.exoplayer2.SimpleExoPlayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Player {

    @Provides
    @Singleton
    fun getPlayer(@ApplicationContext context: Context): SimpleExoPlayer {
        return SimpleExoPlayer.Builder(context).build()
    }
}