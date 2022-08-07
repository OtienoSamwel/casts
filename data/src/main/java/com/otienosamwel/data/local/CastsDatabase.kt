package com.otienosamwel.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [], exportSchema = false, version = 1)
abstract class CastsDatabase : RoomDatabase() {
    abstract fun podcastDao(): PodcastDao
}