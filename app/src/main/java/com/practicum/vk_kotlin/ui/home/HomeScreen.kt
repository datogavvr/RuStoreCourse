package com.practicum.vk_kotlin.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.practicum.vk_kotlin.ui.theme.Vk_kotlinTheme

@Composable
fun HomeScreen(
    onAppClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        HomeHeader()
        HomeAppList(onAppClick)
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    Vk_kotlinTheme {
        HomeScreen({})
    }
}