package com.practicum.vk_kotlin.repository

import com.practicum.vk_kotlin.data.AppApi
import com.practicum.vk_kotlin.data.appdetails.AppDetailsDto
import com.practicum.vk_kotlin.data.appdetails.AppDetailsMapper
import com.practicum.vk_kotlin.data.appdetails.AppDetailsRepositoryImpl
import com.practicum.vk_kotlin.data.local.AppDetailsDao
import com.practicum.vk_kotlin.data.local.AppDetailsEntity
import com.practicum.vk_kotlin.data.local.AppDetailsEntityMapper
import com.practicum.vk_kotlin.domain.appdetails.AppDetails
import com.practicum.vk_kotlin.domain.appdetails.Category
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class AppDetailsRepositoryTest {
    val api: AppApi = mockk()
    val mapper: AppDetailsMapper = mockk()
    val dbMapper: AppDetailsEntityMapper = mockk()
    val dao: AppDetailsDao = mockk(relaxUnitFun = true)
    val repository = AppDetailsRepositoryImpl(api, mapper, dbMapper, dao)

    val appId = "123"
    val expectedDto = AppDetailsDto(
        id = appId,
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
        id = appId,
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
        id = appId,
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
    fun `get app from Dao EXPECT app details`() = runTest {
        coEvery { dao.getAppDetails(appId) } returns expectedEntity
        coEvery { dbMapper.toDomain(expectedEntity) } returns expectedDomain
        val result = repository.get(appId)
        assertEquals("123", result.id)
    }

    @Test
    fun `get app from API EXPECT app details and save to Dao`() = runTest {
        coEvery { dao.getAppDetails(appId) } returns null
        coEvery { api.getAppDetails(appId) } returns expectedDto
        coEvery { mapper.toDomain(expectedDto) } returns expectedDomain
        coEvery { dbMapper.toEntity(expectedDomain) } returns expectedEntity
        coEvery { dao.insertAppDetails(any()) } just Runs
        val result = repository.get(appId)
        assertEquals("123", result.id)
        coVerify(exactly = 1) { dao.insertAppDetails(any()) }
    }

    @Test
    fun `toggleFavorite EXPECT call Dao toggle`() = runTest {
        coEvery { dao.toggleFavorite(appId) } just Runs
        repository.toggleFavorite(appId)
        coVerify(exactly = 1) { dao.toggleFavorite(appId) }
    }

    @Test
    fun `observeAppDetails EXPECT domain flow`() = runTest {
        every { dao.observeAppDetails(appId) } returns flowOf(expectedEntity)
        coEvery { dbMapper.toDomain(expectedEntity) } returns expectedDomain
        val result = repository.observeAppDetails(appId)
        result.collect { appDetails ->
            assertEquals("VK", appDetails.name)
        }
    }
}