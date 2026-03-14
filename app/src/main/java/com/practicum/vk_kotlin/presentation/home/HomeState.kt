package com.practicum.vk_kotlin.presentation.home

import androidx.compose.runtime.Immutable
import com.practicum.vk_kotlin.domain.home.ShortAppDetails

@Immutable
sealed interface HomeState {
    data object Error : HomeState
    data object Loading : HomeState
    data class Content(
        val appDetails: List<ShortAppDetails>,
    ) : HomeState
}