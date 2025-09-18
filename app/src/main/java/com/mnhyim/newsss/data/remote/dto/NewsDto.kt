package com.mnhyim.newsss.data.remote.dto

data class NewsDto(
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)