package com.mnhyim.newsss.ui.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mnhyim.newsss.domain.model.News
import com.mnhyim.newsss.ui.components.HomeHeader
import com.mnhyim.newsss.ui.components.NewsItem
import com.mnhyim.newsss.ui.navigation.Routes
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun Home(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    when {
        state.isLoading -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        }

        else -> {
            HomeScreen(
                news = state.news,
                lastFetch = "",
                onNavigate = onNavigate,
                onRefresh = viewModel::getTopHeadlines,
                modifier = modifier
            )
        }
    }
}

@Composable
private fun HomeScreen(
    news: List<News>,
    lastFetch: String,
    onNavigate: (Routes) -> Unit,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        HomeHeader(
            lastFetch = lastFetch,
            onRefresh = onRefresh,
            modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 8.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp, 8.dp, 16.dp, 16.dp),
        ) {
            items(items = news) {
                NewsItem(
                    news = it,
                    onClick = {
                        onNavigate(
                            Routes.Detail(
                                title = it.title,
                                source = it.source,
                                description = it.description,
                                url = it.url,
                                urlToImage = it.urlToImage,
                                publishedAt = it.publishedAt.toString()
                            )
                        )
                    }
                )
            }
        }
    }

}