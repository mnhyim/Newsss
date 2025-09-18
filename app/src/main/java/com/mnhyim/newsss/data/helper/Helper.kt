package com.mnhyim.newsss.data.helper

import com.mnhyim.newsss.data.local.entity.NewsEntity
import com.mnhyim.newsss.data.remote.dto.NewsDto
import com.mnhyim.newsss.domain.model.News
import java.time.Instant

fun NewsEntity.toDomain() = News(
    title = title,
    source = source.name ?: "",
    description = description ?: "",
    url = url,
    urlToImage = urlToImage,
    publishedAt = Instant.parse(publishedAt)
)

fun NewsDto.toDomain() = News(
    title = title ?: "",
    source = source.name ?: "",
    description = description ?: "",
    url = url ?: "",
    urlToImage = urlToImage ?: "",
    publishedAt = Instant.parse(publishedAt)
)