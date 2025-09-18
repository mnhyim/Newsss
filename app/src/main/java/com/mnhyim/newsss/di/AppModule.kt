package com.mnhyim.newsss.di

import com.mnhyim.newsss.data.repository.NewsRepositoryImpl
import com.mnhyim.newsss.domain.model.News
import com.mnhyim.newsss.domain.repository.NewsRepository
import com.mnhyim.newsss.ui.feature.detail.DetailViewModel
import com.mnhyim.newsss.ui.feature.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single<NewsRepository> { NewsRepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { (news: News) -> DetailViewModel(news) }
}