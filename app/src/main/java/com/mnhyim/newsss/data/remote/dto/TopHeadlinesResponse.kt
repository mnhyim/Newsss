package com.mnhyim.newsss.data.remote.dto

data class TopHeadlinesResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsDto>,
)