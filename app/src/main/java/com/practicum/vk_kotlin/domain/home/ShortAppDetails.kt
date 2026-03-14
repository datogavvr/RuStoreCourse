package com.practicum.vk_kotlin.domain.home

import com.practicum.vk_kotlin.domain.appdetails.Category

data class ShortAppDetails(
    val name: String,
    val category: Category,
    val iconUrl: String,
    val shortDescription: String,
)
