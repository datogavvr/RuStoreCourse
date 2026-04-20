package com.practicum.vk_kotlin.data.local

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.practicum.vk_kotlin.domain.appdetails.AppDetails

class AppDetailsEntityMapper {
    private val gson = GsonBuilder()
        .disableHtmlEscaping()
        .create()

    fun toEntity(domain: AppDetails): AppDetailsEntity = AppDetailsEntity(
        id = domain.id,
        name = domain.name,
        developer = domain.developer,
        category = domain.category,
        ageRating = domain.ageRating,
        size = domain.size,
        iconUrl = domain.iconUrl,
        screenshots = gson.toJson(domain.screenshotUrlList),
        description = domain.description,
        isFavorite = domain.isFavorite
    )

    fun toDomain(entity: AppDetailsEntity): AppDetails = AppDetails(
        id = entity.id,
        name = entity.name,
        developer = entity.developer,
        category = entity.category,
        ageRating = entity.ageRating,
        size = entity.size,
        iconUrl = entity.iconUrl,
        screenshotUrlList = gson.fromJson(entity.screenshots, object : TypeToken<List<String>>() {}.type),
        description = entity.description,
        isFavorite = entity.isFavorite
    )
}