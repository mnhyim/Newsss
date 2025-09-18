package com.mnhyim.newsss.domain.repository

import com.mnhyim.newsss.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getTopHeadlines(): Result<List<News>>
}