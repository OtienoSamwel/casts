package com.os.casts.ui.services.adapter

import android.app.PendingIntent
import android.graphics.Bitmap
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerNotificationManager

class PlayerDescriptionAdapter(private val intent: PendingIntent): PlayerNotificationManager.MediaDescriptionAdapter {
    override fun getCurrentContentTitle(player: Player): CharSequence {
        return player.currentMediaItem.toString()
    }

    override fun createCurrentContentIntent(player: Player): PendingIntent? {
        return intent
    }

    override fun getCurrentContentText(player: Player): CharSequence? {
        return "This is just a test"
    }

    override fun getCurrentLargeIcon(
        player: Player,
        callback: PlayerNotificationManager.BitmapCallback
    ): Bitmap? {
        return null
    }
}