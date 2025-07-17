package com.proyecto.gyeapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
                .padding(horizontal = dimensionResource(R.dimen.padding_medium)),
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
                        .fillMaxWidth()
                        .padding(dimensionResource(R.dimen.padding_medium))
                        .shadow(dimensionResource(R.dimen.padding_medium)),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = stringResource(recommendation.description),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = dimensionResource(R.dimen.padding_medium))
                    .verticalScroll(rememberScrollState()),
            )

        }
    } else {
        Column(
            modifier = modifier
                .padding(horizontal = dimensionResource(R.dimen.padding_medium)),
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
                        .fillMaxWidth()
                        .padding(dimensionResource(R.dimen.padding_medium))
                        .shadow(dimensionResource(R.dimen.padding_medium)),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = stringResource(recommendation.description),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .weight(2f)
                    .padding(top = dimensionResource(R.dimen.padding_medium))
                    .verticalScroll(rememberScrollState()),
            )

        }
    }
}
