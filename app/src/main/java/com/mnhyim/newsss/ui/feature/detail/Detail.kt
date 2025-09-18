package com.mnhyim.newsss.ui.feature.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mnhyim.newsss.domain.model.News
import com.mnhyim.newsss.ui.navigation.Routes

@Composable
fun Detail(
    onNavigate: (Routes) -> Unit,
    news: News,
    modifier: Modifier = Modifier
) {
    DetailScreen(
        modifier = modifier
    )
}

@Composable
private fun DetailScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(text = "DetailScreen")
    }
}