package com.mnhyim.newsss.ui.feature.home

import com.mnhyim.newsss.domain.model.News

data class HomeUiState(
    val news: List<News> = emptyList(),
)
