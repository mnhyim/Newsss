package com.mnhyim.newsss.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {
    @Serializable
    data object Home : Routes()

    @Serializable
    data class Detail(
        val title: String,
        val source: String,
        val description: String,
        val url: String,
        val urlToImage: String,
        val publishedAt: String
    ) : Routes()
}