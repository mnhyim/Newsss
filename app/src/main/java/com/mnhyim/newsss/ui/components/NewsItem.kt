package com.mnhyim.newsss.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mnhyim.newsss.domain.model.News
import com.mnhyim.newsss.ui.util.toRelativeTimeString

@Composable
fun NewsItem(
    news: News,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        onClick = onClick,
        border = CardDefaults.outlinedCardBorder(enabled = false),
        modifier = modifier
    ) {
        Column {
            NewsImage(url = news.urlToImage)
            Text(
                text = news.publishedAt.toRelativeTimeString(),
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray,
                modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 8.dp)
            )
            Text(
                text = news.title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 16.dp)
            )
        }
    }
}