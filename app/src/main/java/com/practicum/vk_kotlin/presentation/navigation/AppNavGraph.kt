package com.practicum.vk_kotlin.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.practicum.vk_kotlin.presentation.appdetails.AppDetailsScreen
import com.practicum.vk_kotlin.presentation.home.HomeScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.HOME.name,
        enterTransition = {
            EnterTransition.None
        },
        exitTransition = {
            ExitTransition.None
        }
    ) {
        composable(Routes.HOME.name) {
            HomeScreen(onAppClick = { navController.navigate(Routes.APP_DETAILS.name) })
        }

        composable(Routes.APP_DETAILS.name) {
            AppDetailsScreen(onBackClick = { navController.popBackStack() })
        }
    }
}