package com.os.castsinapod.ui.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.LifecycleService
import androidx.navigation.NavDeepLinkBuilder
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerNotificationManager
import com.os.castsinapod.HomeActivity
import com.os.castsinapod.MediaDrawerFragment
import com.os.castsinapod.R
import com.os.castsinapod.ui.services.adapter.PlayerDescriptionAdapter
import com.os.castsinapod.ui.utils.Constants.NOTIFICATION_CHANNEL_ID
import com.os.castsinapod.ui.utils.Constants.NOTIFICATION_CHANNEL_NAME
import com.os.castsinapod.ui.utils.Constants.NOTIFICATION_ID
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PlayerService : LifecycleService() {

    private lateinit var notificationManager: NotificationManagerCompat
    @Inject
    lateinit var player: SimpleExoPlayer


    override fun onCreate() {
        super.onCreate()
        notificationManager = NotificationManagerCompat.from(this)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()
        createPlayerNotificationManager()
        return super.onStartCommand(intent, flags, startId)
    }


    private fun getPlayerViewIntent(): PendingIntent {
        return NavDeepLinkBuilder(this)
            .setGraph(R.navigation.main_nav_graph)
            .setDestination(R.id.mediaDrawerFragment)
            .createPendingIntent()
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


    private fun createPlayerNotificationManager(url: String) {
        startForeground(NOTIFICATION_ID, getNotificationBuilder().build())

        val playerNotificationManager = PlayerNotificationManager.Builder(
            this,
            NOTIFICATION_ID,
            NOTIFICATION_CHANNEL_ID,
            PlayerDescriptionAdapter(getPlayerViewIntent())
        ).build()
        playerNotificationManager.setPlayer(player)
        val mediaItem =
            MediaItem.fromUri(url)
        player.setMediaItem(mediaItem)
        player.prepare()
    }

    private fun stopService() {
        notificationManager.cancel(NOTIFICATION_ID)
        stopForeground(true)
        stopSelf()
    }

    private fun getNotificationBuilder(): NotificationCompat.Builder {
        return NotificationCompat.Builder(
            this,
            NOTIFICATION_CHANNEL_ID
        )
    }

}

