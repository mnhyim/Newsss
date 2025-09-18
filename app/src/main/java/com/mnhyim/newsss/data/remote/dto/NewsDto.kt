package com.mnhyim.newsss.data.remote.dto

data class NewsDto(
    val source: SourceDto,
    val author: String,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String,
    /* TODO: API returns ISO-8601 string, convert to Instant later*/
    val publishedAt: String,
    val content: String?
)