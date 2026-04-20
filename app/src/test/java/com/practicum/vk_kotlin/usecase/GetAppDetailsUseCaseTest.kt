package com.practicum.vk_kotlin.usecase

import com.practicum.vk_kotlin.domain.appdetails.AppDetails
import com.practicum.vk_kotlin.domain.appdetails.AppDetailsRepository
import com.practicum.vk_kotlin.domain.appdetails.Category
import com.practicum.vk_kotlin.domain.appdetails.GetAppDetailsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GetAppDetailsUseCaseTest {
    val repository: AppDetailsRepository = mockk()
    val useCase = GetAppDetailsUseCase(repository)

    @Test
    fun `get app details when category is social EXPECT success`() = runTest {
        val appId = "123"
        val expectedApp = AppDetails(
            id = "123",
            name = "vk",
            developer = "vk",
            category = Category.SOCIAL,
            ageRating = 0,
            size = 200f,
            iconUrl = "https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            screenshotUrlList = listOf("https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            description = "Здесь переписываемся",
            isFavorite = true
        )
        coEvery { repository.get(appId) } returns expectedApp

        val result = useCase(appId)

        assertEquals(expectedApp, result)
    }

    @Test(expected = IllegalStateException::class)
    fun `invoke should throw IllegalStateException when category is GAME`() = runTest {
        val appId = "124"
        val gameApp = AppDetails(
            id = "124",
            name = "The Witcher 4",
            developer = "CD Project Red",
            category = Category.GAME,
            ageRating = 0,
            size = 200f,
            iconUrl = "https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            screenshotUrlList = listOf("https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
            description = "GOTY",
            isFavorite = true
        )
        coEvery { repository.get(appId) } returns gameApp

        useCase(appId)
    }
}