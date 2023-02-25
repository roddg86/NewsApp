package com.myapp.android.newsapp.data.db

import androidx.room.*
import com.myapp.android.newsapp.models.Article

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articles")
    fun getAllArticles(): List<Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Delete
    suspend fun delete(article: Article)

}