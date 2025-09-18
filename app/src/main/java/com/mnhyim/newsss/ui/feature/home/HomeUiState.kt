package com.mnhyim.newsss.ui.feature.home

import com.mnhyim.newsss.domain.model.News
import java.time.Instant

data class HomeUiState(
    val news: List<News> = emptyList(),
    val isLoading: Boolean = false,
    val lastFetch: Instant? = null,
)
