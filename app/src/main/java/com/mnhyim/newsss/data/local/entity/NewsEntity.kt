package com.mnhyim.newsss.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("news")
data class NewsEntity(
    val author: String?,
    val title: String,
    val description: String?,
    @PrimaryKey val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String?,
)