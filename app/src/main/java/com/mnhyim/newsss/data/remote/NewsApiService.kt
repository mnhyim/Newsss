package com.mnhyim.newsss.data.remote

import com.mnhyim.newsss.data.remote.dto.TopHeadlinesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
    ): TopHeadlinesResponse
}