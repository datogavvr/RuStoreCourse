package com.practicum.vk_kotlin.data.home

import com.practicum.vk_kotlin.domain.home.HomeAppDetails

class HomeAppDetailsMapper {
    fun toDomain(dto: HomeAppDetailsDto) : HomeAppDetails = HomeAppDetails(
            id = dto.id,
            name = dto.name,
            category = dto.category,
            iconUrl = dto.iconUrl,
            shortDescription = dto.shortDescription
    )
}
