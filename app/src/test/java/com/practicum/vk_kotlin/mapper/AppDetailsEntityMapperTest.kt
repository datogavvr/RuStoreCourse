package com.practicum.vk_kotlin.mapper

import com.practicum.vk_kotlin.data.local.AppDetailsEntity
import com.practicum.vk_kotlin.data.local.AppDetailsEntityMapper
import com.practicum.vk_kotlin.domain.appdetails.AppDetails
import com.practicum.vk_kotlin.domain.appdetails.Category
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AppDetailsEntityMapperTest {
    private val mapper = AppDetailsEntityMapper()

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

    val expectedEntity = AppDetailsEntity(
        id = "123",
        name = "VK",
        category = Category.SOCIAL,
        iconUrl = "https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        developer = "VK",
        ageRating = 0,
        size = 200f,
        screenshots = """["https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"]""",
        description = "Здесь переписываемся",
        isFavorite = false
    )

    @Test
    fun `toEntity EXPECT correct mapping`() {
        val result = mapper.toEntity(expectedDomain)

        // совпадает все, кроме lastUpdated
        assertEquals(expectedEntity.id, result.id)
        assertEquals(expectedEntity.name, result.name)
        assertEquals(expectedEntity.category, result.category)
        assertEquals(expectedEntity.iconUrl, result.iconUrl)
        assertEquals(expectedEntity.developer, result.developer)
        assertEquals(expectedEntity.ageRating, result.ageRating)
        assertEquals(expectedEntity.size, result.size)
        assertEquals(expectedEntity.screenshots, result.screenshots)
        assertEquals(expectedEntity.description, result.description)
        assertEquals(expectedEntity.isFavorite, result.isFavorite)
    }

    @Test
    fun `toEntity EXPECT favorite status is true`() {
        val domain = expectedDomain.copy(isFavorite = true)
        val result = mapper.toEntity(domain)
        assertTrue(result.isFavorite)
    }

    @Test
    fun `toDomain EXPECT correct mapping`() {
        val result = mapper.toDomain(expectedEntity)
        assertEquals(expectedDomain, result)
    }

    @Test(expected = Exception::class)
    fun `toDomain EXPECT throw exception when json is invalid`() {
        val entity = expectedEntity.copy(screenshots = "что-то не то")
        mapper.toDomain(entity)
    }
}