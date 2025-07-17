package com.proyecto.gyeapp.ui

import androidx.lifecycle.ViewModel
import com.proyecto.gyeapp.data.Category
import com.proyecto.gyeapp.model.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class GYEAppViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(GYEAppUiState())
    val uiState: StateFlow<GYEAppUiState> = _uiState

    fun updateCurrentCategory(category: Category) {
        _uiState.update {
            it.copy(
                currentSelectedCategory = category
            )
        }
    }

    fun updateCurrentRecommendation(recommendation: Recommendation) {
        _uiState.update {
            it.copy(
                currentSelectedRecommendation = recommendation
            )
        }
    }

    fun updateCategoryScreenState(state: Boolean) {
        _uiState.update {
            it.copy(
                isInCategoryScreen = state
            )
        }
    }
}