package com.mnhyim.newsss.ui.feature.home

import com.mnhyim.newsss.domain.model.News

sealed class HomeScreenState {
    object Loading : HomeScreenState()
    data class Success(val news: List<News>) : HomeScreenState()
    data class Error(val message: String? = null) : HomeScreenState()
}