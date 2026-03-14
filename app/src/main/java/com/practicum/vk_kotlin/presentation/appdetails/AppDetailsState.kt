package com.practicum.vk_kotlin.presentation.appdetails

import androidx.compose.runtime.Immutable
import com.practicum.vk_kotlin.domain.appdetails.AppDetails

@Immutable
sealed interface AppDetailsState {
    data object Error : AppDetailsState
    data object Loading : AppDetailsState
    data class Content(
        val appDetails: AppDetails,
        val descriptionCollapsed: Boolean,
    ) : AppDetailsState
}