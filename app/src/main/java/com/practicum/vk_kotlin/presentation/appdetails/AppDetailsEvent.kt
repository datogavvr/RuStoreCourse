package com.practicum.vk_kotlin.presentation.appdetails

sealed interface AppDetailsEvent {
    data object UnderDevelopment : AppDetailsEvent
}