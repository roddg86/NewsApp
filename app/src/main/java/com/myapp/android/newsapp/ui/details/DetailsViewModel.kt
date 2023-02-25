package com.myapp.android.newsapp.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.android.newsapp.data.api.NewsRepository
import com.myapp.android.newsapp.models.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: NewsRepository) :ViewModel() {

    init {
        getSavedArticles()
    }

    fun getSavedArticles() = viewModelScope.launch(Dispatchers.IO){
        val res = repository.getFavoriteArticles()
        println("DB size: ${res.size}")
        repository.getFavoriteArticles()
    }

    fun saveFavoriteArticle(article: Article) = viewModelScope.launch(Dispatchers.IO) {
        repository.addToFavorite(article = article)
    }
}