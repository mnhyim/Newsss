package com.mnhyim.newsss.ui.feature.detail

import androidx.lifecycle.ViewModel
import com.mnhyim.newsss.domain.model.News
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel(
    private val news: News
) : ViewModel() {

    private val _state = MutableStateFlow(DetailUiState(news))
    val state = _state.asStateFlow()

}