package com.myapp.android.newsapp.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class ArticleDatabase: RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile
        private var inference: ArticleDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = inference?: synchronized(LOCK){
            inference ?: createDatabase(context).also { inference = it }
        }

        private fun createDatabase(context: Context) : ArticleDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_database"
            ).build()
        }
    }
}