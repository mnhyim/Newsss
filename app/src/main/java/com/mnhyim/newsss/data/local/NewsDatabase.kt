package com.mnhyim.newsss.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mnhyim.newsss.data.local.entity.NewsEntity

@Database(
    entities = [NewsEntity::class],
    version = 1,
)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun appDao(): NewsDao
}