package com.mnhyim.newsss.di

import com.mnhyim.newsss.data.repository.NewsRepositoryImpl
import org.koin.dsl.module

val appModule = module {
    single { NewsRepositoryImpl(get()) }
}