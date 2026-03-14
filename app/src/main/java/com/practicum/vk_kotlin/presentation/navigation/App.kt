package com.practicum.vk_kotlin.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.practicum.vk_kotlin.presentation.theme.VkKotlinTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun App() {
    VkKotlinTheme {
        val navController = rememberNavController()
        AppNavGraph(navController = navController)
    }
}