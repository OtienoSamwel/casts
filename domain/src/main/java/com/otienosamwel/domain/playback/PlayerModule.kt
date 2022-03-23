package com.otienosamwel.domain.playback

import android.content.Context
import androidx.media3.common.AudioAttributes
import androidx.media3.common.C
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaSession
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PlayerModule {

    @Provides
    @Singleton
    fun providePlayer(@ApplicationContext context: Context): ExoPlayer {
        return ExoPlayer.Builder(context)
            .setAudioAttributes(AudioAttributes.DEFAULT, true)
            .setHandleAudioBecomingNoisy(true)
            .setWakeMode(C.WAKE_MODE_LOCAL)
            .build()
    }
}


@Module
@InstallIn(SingletonComponent::class)
class MediaSessionModule {

    @Provides
    @Singleton
    fun provideMediaSession(@ApplicationContext context: Context, player: ExoPlayer): MediaSession {
        return MediaSession.Builder(context, player).build()
    }
}