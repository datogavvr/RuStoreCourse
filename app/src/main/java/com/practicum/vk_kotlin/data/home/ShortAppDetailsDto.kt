package com.practicum.vk_kotlin.data.home

import com.practicum.vk_kotlin.domain.appdetails.Category

data class ShortAppDetailsDto(
    val name: String,
    val category: Category,
    val iconUrl: String,
    val shortDescription: String,
)
