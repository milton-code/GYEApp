package com.proyecto.gyeapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.proyecto.gyeapp.R
import com.proyecto.gyeapp.model.Recommendation
import com.proyecto.gyeapp.ui.utils.ContentType


@Composable
fun GYEAppDetailScreen(
    recommendation: Recommendation,
    contentType: ContentType,
    modifier: Modifier = Modifier
) {
    if (contentType == ContentType.LIST_AND_DETAIL) {
        Row(
            modifier = modifier
                .padding(horizontal = dimensionResource(R.dimen.padding_large)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center,
                propagateMinConstraints = true
            ) {
                Image(
                    painter = painterResource(recommendation.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = dimensionResource(R.dimen.padding_large))
                        .shadow(dimensionResource(R.dimen.padding_medium)),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = stringResource(recommendation.description),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = dimensionResource(R.dimen.padding_large),
                        top = dimensionResource(R.dimen.padding_large),
                        bottom = dimensionResource(R.dimen.padding_large))
                    .verticalScroll(rememberScrollState()),
            )

        }
    } else {
        Column(
            modifier = modifier
                .padding(horizontal = dimensionResource(R.dimen.padding_large),
                    vertical = dimensionResource(R.dimen.padding_large)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center,
                propagateMinConstraints = true
            ) {
                Image(
                    painter = painterResource(recommendation.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .shadow(dimensionResource(R.dimen.padding_medium)),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = stringResource(recommendation.description),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .weight(2f)
                    .padding(top = dimensionResource(R.dimen.padding_large))
                    .verticalScroll(rememberScrollState()),
            )

        }
    }
}

@Preview(showBackground = true,
    widthDp = 640,
    heightDp = 340)
@Composable
fun GYEAppDetailScreenPreview() {
    val gyeAppUiState = GYEAppUiState()
    val contentType = ContentType.LIST_AND_DETAIL
    GYEAppDetailScreen(
        recommendation = gyeAppUiState.currentSelectedRecommendation,
        contentType = contentType
    )
}
