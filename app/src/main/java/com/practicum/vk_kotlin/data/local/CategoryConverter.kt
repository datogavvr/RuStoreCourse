package com.practicum.vk_kotlin.data.local

import androidx.room.TypeConverter
import com.practicum.vk_kotlin.domain.appdetails.Category

class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: Category): String = category.name

    @TypeConverter
    fun toCategory(categoryName: String): Category = Category.valueOf(categoryName)
}