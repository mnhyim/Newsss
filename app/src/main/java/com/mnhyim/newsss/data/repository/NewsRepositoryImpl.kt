package com.mnhyim.newsss.data.repository

import com.mnhyim.newsss.data.helper.toDomain
import com.mnhyim.newsss.data.local.entity.NewsEntity
import com.mnhyim.newsss.data.remote.NewsApiService
import com.mnhyim.newsss.domain.model.News
import com.mnhyim.newsss.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import timber.log.Timber

class NewsRepositoryImpl(
    private val api: NewsApiService
) : NewsRepository {
    override suspend fun getTopHeadlines(): Result<List<News>> {
        return withContext(Dispatchers.IO) {
            /* TODO: Get local data from Room here */
            val local: List<NewsEntity> = emptyList()

            try {
                val remote = api.getTopHeadlines(country = "us").articles
                /* TODO: Should insert fetched data into Room here later */
                Result.success(remote.map { it.toDomain() })
            } catch (e: Exception) {
                Timber.d("E: ${e.localizedMessage}")
                local.let { Result.success(it.map { news -> news.toDomain() }) } ?: Result.failure(e)
            }
        }
    }
}