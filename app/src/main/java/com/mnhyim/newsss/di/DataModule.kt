package com.mnhyim.newsss.di

import com.mnhyim.newsss.BuildConfig
import com.mnhyim.newsss.data.remote.NewsApiService
import com.mnhyim.newsss.data.util.ApiKeyInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {
    /* TODO: declare Room stuff here later for offline persistence */
}

val networkModule = module {
    single<Moshi> {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single { ApiKeyInterceptor(BuildConfig.NEWS_API_KEY) }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<ApiKeyInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2")
            .client(get<OkHttpClient>())
            .addConverterFactory(MoshiConverterFactory.create(get<Moshi>()))
            .build()
    }

    single { get<Retrofit>().create(NewsApiService::class.java) }
}