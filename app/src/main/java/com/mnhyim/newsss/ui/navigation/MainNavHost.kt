package com.mnhyim.newsss.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.mnhyim.newsss.domain.model.News
import com.mnhyim.newsss.ui.feature.detail.Detail
import com.mnhyim.newsss.ui.feature.detail.DetailViewModel
import com.mnhyim.newsss.ui.feature.home.Home
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import java.time.Instant

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home
    ) {
        composable<Routes.Home> {
            Home(
                onNavigate = { navController.navigate(it) },
                modifier = modifier
            )
        }
        composable<Routes.Detail> { backStackEntry ->
            /* TODO: Can be improved by passing object directly or pass id and fetch based on id */
            val backstack = backStackEntry.toRoute<Routes.Detail>()
            val news = News(
                title = backstack.title,
                description = backstack.description,
                url = backstack.url,
                urlToImage = backstack.urlToImage,
                publishedAt = Instant.parse(backstack.publishedAt)
            )
            val viewModel: DetailViewModel = koinViewModel(
                parameters = { parametersOf(news) }
            )
            Detail(
                viewModel = viewModel,
                modifier = modifier
            )
        }
    }
}