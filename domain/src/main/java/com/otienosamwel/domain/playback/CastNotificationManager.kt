package com.otienosamwel.domain.playback

import android.app.PendingIntent
import android.content.Context
import android.graphics.Bitmap
import androidx.core.app.NotificationCompat.PRIORITY_LOW
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerNotificationManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CastNotificationManager @Inject constructor(
    private val player: ExoPlayer,
    @ApplicationContext private val context: Context,
) {

    val notificationManager: PlayerNotificationManager =
        PlayerNotificationManager.Builder(context, NOTIFICATION_ID, NOTIFICATION_CHANNEL_ID)
            .setMediaDescriptionAdapter(DescriptionAdapter())
            .build()
            .also {
                it.setPriority(PRIORITY_LOW)
                it.setPlayer(player)
            }

    private inner class DescriptionAdapter : PlayerNotificationManager.MediaDescriptionAdapter {

        override fun getCurrentContentTitle(player: Player): CharSequence {
            return "sam"
        }

        override fun createCurrentContentIntent(player: Player): PendingIntent? {
            return null
        }

        override fun getCurrentContentText(player: Player): CharSequence? {
            return null
        }

        override fun getCurrentLargeIcon(
            player: Player,
            callback: PlayerNotificationManager.BitmapCallback
        ): Bitmap? {
            return null
        }

    }
}