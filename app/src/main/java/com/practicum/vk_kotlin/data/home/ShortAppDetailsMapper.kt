package com.practicum.vk_kotlin.data.home

import com.practicum.vk_kotlin.domain.home.ShortAppDetails

class ShortAppDetailsMapper {
    fun toDomain(dto: ShortAppDetailsDto) : ShortAppDetails = ShortAppDetails(
            name = dto.name,
            category = dto.category,
            iconUrl = dto.iconUrl,
            shortDescription = dto.shortDescription
    )
}
