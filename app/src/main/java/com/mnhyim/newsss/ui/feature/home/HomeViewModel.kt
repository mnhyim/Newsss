package com.mnhyim.newsss.ui.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.newsss.domain.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel(
    /* TODO: Probably should use Usecase later instead of accessing repository directly here*/
    private val repository: NewsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getTopHeadlines()
    }

    fun getTopHeadlines() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            repository.getTopHeadlines()
                .onSuccess { result ->
                    _state.update {
                        it.copy(
                            news = result,
                            isLoading = false,
                            lastFetch = result[0].publishedAt
                        )
                    }
                }
                .onFailure { exception ->
                    Timber.d(exception)
                    _state.update { it.copy(isLoading = false) }
                }
        }
    }
}