package com.otienosamwel.domain.playback

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.widget.Toast
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PlaybackService : Service() {

    @Inject
    lateinit var player: ExoPlayer

    inner class MyBinder : Binder() {
        fun getService(): PlaybackService = this@PlaybackService
    }

    override fun onBind(p0: Intent?): IBinder {
        return MyBinder()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "onstart command", Toast.LENGTH_SHORT).show()
        return super.onStartCommand(intent, flags, startId)
    }

    fun playMedia(mediaURL: String) {
        player.run {
            addMediaItem(MediaItem.fromUri(mediaURL))
            prepare()
            play()
        }
    }


}