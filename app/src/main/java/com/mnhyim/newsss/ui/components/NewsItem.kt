package com.mnhyim.newsss.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            /* TODO: News image should be here, fallback to icon when there's no image or network error */
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.primary,
                        RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp)
                    )
            ) {
                Icon(
                    /* TODO: Should change to correct Icon from Material Icons Extended later */
                    imageVector = Icons.Outlined.Email,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(40.dp)
                )
            }

            Text(
                text = news.publishedAt.toRelativeTimeString(),
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 4.dp)
            )
            Text(
                text = news.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 8.dp)
            )
        }
    }
}