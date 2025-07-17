package com.proyecto.gyeapp.ui

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.proyecto.gyeapp.R
import com.proyecto.gyeapp.data.Category
import com.proyecto.gyeapp.model.Recommendation

@Composable
fun GYEAppListScreen(
    modifier: Modifier = Modifier,
    onCategoryCardPressed: (Category) -> Unit = {},
    onRecommendationCardPressed: (Recommendation) -> Unit = {},
    gyeAppUiState: GYEAppUiState,
    route: String?
) {

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(R.dimen.padding_medium)
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (route == GYEAppScreen.Category.name) {
            items(items = Category.categoryList) {
                Log.e("nullPointer", "El valor de items es: $it")
                CategoryListItem(
                    category = it,
                    modifier = Modifier
                        .height(dimensionResource(R.dimen.card_height))
                        .fillMaxWidth(),
                    onCategorySelected = {
                        onCategoryCardPressed(it)
                    }
                )
            }
        } else {
            items(items = gyeAppUiState.currentSelectedCategory.getRecommendations()) {
                RecommendationListItem(
                    recommendation = it,
                    onRecommendationSelected = { onRecommendationCardPressed(it) },
                    modifier = Modifier
                        .height(dimensionResource(R.dimen.card_height))
                        .fillMaxWidth()
                )
            }

        }
    }

}

@Composable
fun CategoryListItem(
    category: Category,
    modifier: Modifier = Modifier,
    onCategorySelected: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        modifier = modifier
            .clickable(
                enabled = true,
                onClick = onCategorySelected
            )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(category.name),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun RecommendationListItem(
    recommendation: Recommendation,
    onRecommendationSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        modifier = modifier
            .clickable(
                enabled = true,
                onClick = onRecommendationSelected
            )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(height = dimensionResource(R.dimen.card_height),
                        width = dimensionResource(R.dimen.card_image_width))
            ) {
                RecommendationImg(
                    image = recommendation.image
                )
            }
            Text(
                text = stringResource(recommendation.name),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun RecommendationImg(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(image),
        contentDescription = "",
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}
