package com.practicum.vk_kotlin.data.appdetails

import com.practicum.vk_kotlin.domain.appdetails.Category

data class AppDetailsDto(
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Double,
    val icon: String,
    val screenshots: List<String>,
    val description: String,
)