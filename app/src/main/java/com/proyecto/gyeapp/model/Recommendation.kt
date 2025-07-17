package com.proyecto.gyeapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recommendation(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int
)
