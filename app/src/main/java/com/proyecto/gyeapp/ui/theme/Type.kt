package com.proyecto.gyeapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.proyecto.gyeapp.R


val OpenSans = FontFamily(
    Font(R.font.opensans_regular),
    Font(R.font.opensans_bold, FontWeight.Bold)
)

val baseline = Typography()
val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = OpenSans),
    displayMedium = baseline.displayMedium.copy(fontFamily = OpenSans),
    displaySmall = baseline.displaySmall.copy(fontFamily = OpenSans),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = OpenSans),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = OpenSans),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = OpenSans),
    titleLarge = baseline.titleLarge.copy(fontFamily = OpenSans),
    titleMedium = baseline.titleMedium.copy(fontFamily = OpenSans),
    titleSmall = baseline.titleSmall.copy(fontFamily = OpenSans),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = OpenSans),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = OpenSans, textAlign = TextAlign.Justify),
    bodySmall = baseline.bodySmall.copy(fontFamily = OpenSans),
    labelLarge = baseline.labelLarge.copy(fontFamily = OpenSans),
    labelMedium = baseline.labelMedium.copy(fontFamily = OpenSans),
    labelSmall = baseline.labelSmall.copy(fontFamily = OpenSans),
)
