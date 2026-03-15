package com.practicum.vk_kotlin.presentation.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.practicum.vk_kotlin.R
import com.practicum.vk_kotlin.presentation.theme.VkKotlinTheme
import kotlinx.coroutines.flow.Flow

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onAppClick: () -> Unit
) {
    val viewModel = viewModel<HomeViewModel>()
    val state by viewModel.state.collectAsState()
    val events = viewModel.events

    val snackbarHostState = remember { SnackbarHostState() }

    ObserveEvents(
        events = events,
        snackbarHostState = snackbarHostState,
    )

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(padding)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            HomeHeader( onLogoClick = { viewModel.showOnLogoClickMessage() })
            when (val currentState = state) {
                is HomeState.Content -> HomeAppList(apps = currentState.apps, onAppClick = onAppClick)
                is HomeState.Error -> HomeError(
                    onRefreshClick = { viewModel.getApps() },
                )
                is HomeState.Loading -> HomeLoading()
            }
        }
    }
}

@Composable
private fun ObserveEvents(
    events: Flow<HomeEvent>,
    snackbarHostState: SnackbarHostState
) {
    val underDevelopementText = stringResource(R.string.app_description)

    LaunchedEffect(Unit) {
        events.collect { event ->
            when (event) {
                is HomeEvent.OnLogoClick -> {
                    snackbarHostState.showSnackbar(underDevelopementText)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun LightPreview() {
    VkKotlinTheme {
        HomeScreen {}
    }
}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkPreview() {
    VkKotlinTheme {
        HomeScreen {}
    }
}