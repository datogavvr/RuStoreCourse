package com.practicum.vk_kotlin.domain.home

import com.practicum.vk_kotlin.domain.appdetails.Category

data class HomeAppDetails(
    val id: String,
    val name: String,
    val category: Category,
    val iconUrl: String,
    val shortDescription: String,
)
