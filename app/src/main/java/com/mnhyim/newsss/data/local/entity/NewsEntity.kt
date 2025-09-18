package com.mnhyim.newsss.data.local.entity

import com.mnhyim.newsss.data.remote.dto.SourceDto

/* TODO: add @Entity annotation later */
data class NewsEntity(
    val source: SourceDto,
    val author: String,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String?
)