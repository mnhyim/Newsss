package com.mnhyim.newsss.domain.repository

import com.mnhyim.newsss.domain.model.News

interface NewsRepository {

    suspend fun getTopHeadlines(): Result<List<News>>
}