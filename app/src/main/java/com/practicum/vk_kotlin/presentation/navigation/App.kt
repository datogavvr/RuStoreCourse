package com.practicum.vk_kotlin.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.practicum.vk_kotlin.presentation.theme.VkKotlinTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun App() {
    VkKotlinTheme {
        val navController = rememberNavController()

        Scaffold(
            containerColor = MaterialTheme.colorScheme.background
        ) { padding ->
            AppNavGraph(
                navController = navController,
                padding = padding
            )
        }
    }
}