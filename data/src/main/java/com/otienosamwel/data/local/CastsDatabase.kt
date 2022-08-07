package com.otienosamwel.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

abstract class CastsDatabase : RoomDatabase() {
    abstract fun podcastDao(): PodcastDao
}