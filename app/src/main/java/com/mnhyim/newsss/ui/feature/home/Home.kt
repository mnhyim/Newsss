package com.mnhyim.newsss.ui.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mnhyim.newsss.ui.navigation.Routes

@Composable
fun Home(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    HomeScreen(
        modifier = modifier
    )
}

@Composable
private fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(text = "HomeScreen")
    }
}