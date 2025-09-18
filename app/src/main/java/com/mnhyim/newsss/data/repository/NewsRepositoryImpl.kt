package com.mnhyim.newsss.data.repository

import com.mnhyim.newsss.data.helper.toDomain
import com.mnhyim.newsss.data.helper.toEntity
import com.mnhyim.newsss.data.local.NewsDao
import com.mnhyim.newsss.data.remote.NewsApiService
import com.mnhyim.newsss.domain.model.News
import com.mnhyim.newsss.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class NewsRepositoryImpl(
    private val api: NewsApiService,
    private val dao: NewsDao,
) : NewsRepository {
    override suspend fun getTopHeadlines(): Result<List<News>> {
        return withContext(Dispatchers.IO) {
            try {
                val remote = api.getTopHeadlines(country = "us").articles
                remote.forEach { dao.insertNews(it.toEntity()) }
                Result.success(remote.map { it.toDomain() })
            } catch (e: Exception) {
                Timber.d("Remote fetch failed: ${e.localizedMessage}")
                try {
                    val local = dao.getNews()
                    if (local.isNotEmpty()) Result.success(local.map { it.toDomain() })
                    else Result.failure(e)
                } catch (dbEx: Exception) {
                    Timber.d("DB fallback failed: ${dbEx.localizedMessage}")
                    Result.failure(e) // original remote exception
                }
            }
        }
    }
}