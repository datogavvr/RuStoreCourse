package com.practicum.vk_kotlin.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.practicum.vk_kotlin.domain.appdetails.Category

@Entity(tableName = "app_details")
data class AppDetailsEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,
    val screenshots: String? = null,
    val description: String,
    val lastUpdated: Long = System.currentTimeMillis()
)