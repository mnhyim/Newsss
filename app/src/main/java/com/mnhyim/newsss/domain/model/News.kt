package com.mnhyim.newsss.domain.model

import java.time.Instant

data class News(
    val title: String,
    val source: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: Instant
)