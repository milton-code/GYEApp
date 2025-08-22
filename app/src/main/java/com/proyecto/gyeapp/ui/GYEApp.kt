package com.proyecto.gyeapp.ui


import androidx.annotation.StringRes
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.proyecto.gyeapp.R
import com.proyecto.gyeapp.ui.utils.ContentType

enum class GYEAppScreen(@StringRes var title: Int) {
    Category(R.string.categories),
    Recommendation(R.string.recommendations),
    Details(R.string.parks_centenario)
}

@Composable
fun GYEApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val navController: NavHostController = rememberNavController()
    val viewModel: GYEAppViewModel = viewModel()
    val gyeAppUiState: GYEAppUiState = viewModel.uiState.collectAsState().value
    val backStackEntry by navController.currentBackStackEntryAsState()

    val contentType: ContentType = when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            ContentType.LIST_ONLY
        }

        WindowWidthSizeClass.Medium -> {
            ContentType.LIST_ONLY
        }

        WindowWidthSizeClass.Expanded -> {
            ContentType.LIST_AND_DETAIL
        }

        else -> {
            ContentType.LIST_ONLY
        }
    }
    Scaffold(
        topBar = {
            GYEAppTopBar(
                currentScreen = GYEAppScreen
                    .valueOf(backStackEntry?.destination?.route ?: GYEAppScreen.Category.name),
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },
        contentWindowInsets = WindowInsets(
            bottom = WindowInsets
                .navigationBars
                .asPaddingValues()
                .calculateBottomPadding()
        )
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = GYEAppScreen.Category.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            composable(route = GYEAppScreen.Category.name) {
                GYEAppListScreen(
                    modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_medium),
                        horizontal = dimensionResource(R.dimen.padding_large)),
                    onCategoryCardPressed = { category ->
                        viewModel.updateCurrentCategory(category)
                        navController.navigate(route = GYEAppScreen.Recommendation.name)
                    },
                    gyeAppUiState = gyeAppUiState,
                    route = navController.currentDestination?.route
                )
            }
            composable(route = GYEAppScreen.Recommendation.name) {
                GYEAppListScreen(
                    modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_medium),
                        horizontal = dimensionResource(R.dimen.padding_large)),
                    onRecommendationCardPressed = { recommendation ->
                        GYEAppScreen.Details.title = recommendation.name
                        viewModel.updateCurrentRecommendation(recommendation)
                        navController.navigate(route = GYEAppScreen.Details.name)
                    },
                    gyeAppUiState = gyeAppUiState,
                    route = navController.currentDestination?.route
                )
            }
            composable(route = GYEAppScreen.Details.name) {
                GYEAppDetailScreen(
                    recommendation = gyeAppUiState.currentSelectedRecommendation,
                    contentType = contentType
                )
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GYEAppTopBar(
    canNavigateBack: Boolean,
    currentScreen: GYEAppScreen,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(currentScreen.title),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    )
}
