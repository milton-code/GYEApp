package com.proyecto.gyeapp.ui

import com.proyecto.gyeapp.data.Category
import com.proyecto.gyeapp.model.Recommendation

data class GYEAppUiState(
    val currentSelectedCategory: Category = Category.Parks,
    val currentSelectedRecommendation: Recommendation = Category.Parks.getRecommendations()[0],
    val isInCategoryScreen: Boolean = true,
)

