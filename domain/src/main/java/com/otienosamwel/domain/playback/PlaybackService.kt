package com.otienosamwel.domain.playback

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaSession
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PlaybackService : Service() {

    @Inject
    lateinit var player: ExoPlayer

    @Inject
    lateinit var session: MediaSession

    @Inject
    lateinit var castNotificationManager: CastNotificationManager

    private lateinit var notificationManager: NotificationManagerCompat

    override fun onCreate() {
        super.onCreate()
        notificationManager = NotificationManagerCompat.from(this)
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val mediaUrl = intent?.action
        startForegroundServiceWithNotification()
        playMedia(mediaUrl!!)
        castNotificationManager
        Log.i(TAG, "onStartCommand: Starting to play $mediaUrl")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder {
        return PlaybackServiceBinder()
    }

    private fun startForegroundServiceWithNotification() {
        val notification = Notification.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setCategory(Notification.CATEGORY_SERVICE)
            .build()
        startForeground(NOTIFICATION_ID, notification)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                NOTIFICATION_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_LOW
            )
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun playMedia(mediaURL: String) {
        player.addMediaItem(MediaItem.fromUri(mediaURL))
        player.prepare()
        player.play()
    }

    companion object {
        private const val TAG = "PLAYBACK SERVICE"
    }
}

class PlaybackServiceBinder : Binder() {
    fun getService(): PlaybackService = PlaybackService()
}
