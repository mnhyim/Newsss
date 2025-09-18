package com.mnhyim.newsss.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mnhyim.newsss.data.local.entity.NewsEntity

@Dao
interface NewsDao {


    @Query("SELECT * FROM news")
    suspend fun getNews(): List<NewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(vararg user: NewsEntity)

    @Update
    suspend fun updateNews(user: NewsEntity)

    @Delete
    suspend fun deleteNews(user: NewsEntity)
}