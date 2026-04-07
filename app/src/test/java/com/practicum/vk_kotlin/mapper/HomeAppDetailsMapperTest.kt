package com.practicum.vk_kotlin.mapper

import com.practicum.vk_kotlin.data.home.HomeAppDetailsDto
import com.practicum.vk_kotlin.data.home.HomeAppDetailsMapper
import com.practicum.vk_kotlin.domain.appdetails.Category
import com.practicum.vk_kotlin.domain.home.HomeAppDetails
import org.junit.Assert.assertEquals
import org.junit.Test

class HomeAppDetailsMapperTest {
    private val mapper = HomeAppDetailsMapper()

    @Test
    fun `toDomain EXPECT correct mapping`() {
        val dto = HomeAppDetailsDto(
            id = "123",
            name = "VK",
            category = Category.SOCIAL,
            shortDescription = "Здесь переписываемся",
            iconUrl = "https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        )
        val expectedDomain = HomeAppDetails(
            id = "123",
            name = "VK",
            category = Category.SOCIAL,
            shortDescription = "Здесь переписываемся",
            iconUrl = "https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        )
        val result = mapper.toDomain(dto)
        assertEquals(expectedDomain, result)
    }
}