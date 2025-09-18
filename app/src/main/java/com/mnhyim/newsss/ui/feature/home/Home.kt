package com.mnhyim.newsss.ui.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mnhyim.newsss.domain.model.News
import com.mnhyim.newsss.ui.components.NewsItem
import com.mnhyim.newsss.ui.navigation.Routes
import java.time.Instant
import java.time.temporal.ChronoUnit
import kotlin.random.Random

@Composable
fun Home(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    /* TODO: Temporary dummy news data */
    val dummyNews = List(10) { index ->
        val daysAgo = Random.nextLong(0, 7) // 0–6 days ago
        val hoursAgo = Random.nextLong(0, 24)
        val minutesAgo = Random.nextLong(0, 60)

        News(
            title = "News Title #${index + 1}",
            source = "Source #${index + 1}",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            url = "https://example.com/article/${index + 1}",
            urlToImage = "https://picsum.photos/800/400?random=${index + 1}",
            publishedAt = Instant.now()
                .minus(daysAgo, ChronoUnit.DAYS)
                .minus(hoursAgo, ChronoUnit.HOURS)
                .minus(minutesAgo, ChronoUnit.MINUTES)
        )
    }.sortedByDescending { it.publishedAt }

    HomeScreen(
        news = dummyNews,
        onNavigate = onNavigate,
        modifier = modifier
    )
}

@Composable
private fun HomeScreen(
    news: List<News>,
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = modifier
    ) {
        items(items = news) {
            NewsItem(
                news = it,
                onClick = {}
            )
        }
    }
}