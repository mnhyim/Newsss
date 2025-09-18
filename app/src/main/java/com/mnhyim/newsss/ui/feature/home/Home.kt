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
import com.mnhyim.newsss.ui.components.ErrorItem
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

    when (state.screenState) {
        is HomeScreenState.Loading -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        }

        is HomeScreenState.Success -> {
            HomeScreen(
                news = (state.screenState as HomeScreenState.Success).news,
                onNavigate = onNavigate,
                onRefresh = viewModel::getTopHeadlines,
                modifier = modifier
            )
        }

        is HomeScreenState.Error -> {
            ErrorItem(
                errorMessage = (state.screenState as HomeScreenState.Error).message
                    ?: "General Error",
                onRefetch = viewModel::getTopHeadlines,
            )
        }
    }
}

@Composable
private fun HomeScreen(
    news: List<News>,
    onNavigate: (Routes) -> Unit,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        HomeHeader(
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