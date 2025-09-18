package com.mnhyim.newsss.ui.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mnhyim.newsss.domain.model.News
import com.mnhyim.newsss.ui.components.NewsItem
import com.mnhyim.newsss.ui.navigation.Routes
import org.koin.compose.viewmodel.koinViewModel
import java.time.Instant
import java.time.temporal.ChronoUnit
import kotlin.random.Random

@Composable
fun Home(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        news = state.news,
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