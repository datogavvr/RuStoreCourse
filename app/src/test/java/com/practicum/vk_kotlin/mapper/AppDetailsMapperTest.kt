package com.practicum.vk_kotlin.mapper

import com.practicum.vk_kotlin.data.appdetails.AppDetailsDto
import com.practicum.vk_kotlin.data.appdetails.AppDetailsMapper
import com.practicum.vk_kotlin.domain.appdetails.AppDetails
import com.practicum.vk_kotlin.domain.appdetails.Category
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AppDetailsMapperTest {
    private val mapper = AppDetailsMapper()

    @Test
    fun `toDomain EXPECT correct mapping`() {
        val dto = AppDetailsDto(
            id = "123",
            name = "VK",
            category = Category.SOCIAL,
            icon = "https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            developer = "VK",
            ageRating = 0,
            size = 200.0,
            screenshots = listOf("https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            description = "Здесь переписываемся"
        )
        val expectedDomain = AppDetails(
            id = "123",
            name = "VK",
            category = Category.SOCIAL,
            iconUrl = "https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            developer = "VK",
            ageRating = 0,
            size = 200f,
            screenshotUrlList = listOf("https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            description = "Здесь переписываемся"
        )
        val result = mapper.toDomain(dto)

        assertEquals(expectedDomain, result)
    }

    @Test
    fun `toDomain EXPECT empty screenshots when Dto list is empty`() {
        val dto = AppDetailsDto(
            id = "123",
            name = "VK",
            category = Category.SOCIAL,
            icon = "https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            developer = "VK",
            ageRating = 0,
            size = 200.0,
            screenshots = null,
            description = "Здесь переписываемся"
        )
        val result = mapper.toDomain(dto)
        assertTrue(result.screenshotUrlList.isNullOrEmpty())
    }
}