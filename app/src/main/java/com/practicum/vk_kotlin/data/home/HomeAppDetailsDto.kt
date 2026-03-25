package com.practicum.vk_kotlin.data.home

import com.practicum.vk_kotlin.domain.appdetails.Category
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeAppDetailsDto(
    val id: String,
    val name: String,
    val category: Category,
    val iconUrl: String,
    @SerialName("description")
    val shortDescription: String,
)
