package com.mnhyim.newsss.ui.feature.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mnhyim.newsss.domain.model.News
import com.mnhyim.newsss.ui.components.NewsImage
import com.mnhyim.newsss.ui.util.toFormattedDate

@Composable
fun Detail(
    viewModel: DetailViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    DetailScreen(
        news = state.news,
        modifier = modifier.verticalScroll(rememberScrollState())
    )
}

@Composable
private fun DetailScreen(
    news: News,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp, 0.dp, 16.dp, 16.dp)
    ) {
        NewsImage(
            url = news.urlToImage,
        )
        Text(
            text = news.title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 4.dp)
        )
        Text(
            text = news.publishedAt.toFormattedDate(),
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray,
            modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 8.dp)
        )
        Text(
            text = news.description,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}