package com.practicum.vk_kotlin.data.local

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.practicum.vk_kotlin.domain.appdetails.AppDetails

class AppDetailsEntityMapper {

    fun toEntity(domain: AppDetails): AppDetailsEntity = AppDetailsEntity(
        id = domain.id,
        name = domain.name,
        developer = domain.developer,
        category = domain.category,
        ageRating = domain.ageRating,
        size = domain.size,
        iconUrl = domain.iconUrl,
        screenshots = Gson().toJson(domain.screenshotUrlList),
        description = domain.description
    )

    fun toDomain(entity: AppDetailsEntity): AppDetails = AppDetails(
        id = entity.id,
        name = entity.name,
        developer = entity.developer,
        category = entity.category,
        ageRating = entity.ageRating,
        size = entity.size,
        iconUrl = entity.iconUrl,
        screenshotUrlList = Gson().fromJson(entity.screenshots, object : TypeToken<List<String>>() {}.type),
        description = entity.description
    )
}