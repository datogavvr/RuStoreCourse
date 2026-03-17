package com.practicum.vk_kotlin.presentation.home

sealed interface HomeEvent {
    data object OnLogoClick : HomeEvent
}