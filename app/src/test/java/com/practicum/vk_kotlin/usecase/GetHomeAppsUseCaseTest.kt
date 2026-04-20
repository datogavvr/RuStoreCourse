package com.practicum.vk_kotlin.usecase

import com.practicum.vk_kotlin.domain.appdetails.Category
import com.practicum.vk_kotlin.domain.home.GetHomeAppsUseCase
import com.practicum.vk_kotlin.domain.home.HomeAppDetails
import com.practicum.vk_kotlin.domain.home.HomeRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GetHomeAppsUseCaseTest {
    private val repository: HomeRepository = mockk()
    private val useCase = GetHomeAppsUseCase(repository)

    @Test
    fun `get home apps EXPECT apps list`() = runTest {
        val expectedList = listOf(
            HomeAppDetails(
                id = "123",
                name = "VK",
                category = Category.SOCIAL,
                iconUrl = "https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                shortDescription = "Здесь переписываемся"
            ),
            HomeAppDetails(
                id = "125",
                name = "Ozon",
                category = Category.SHOPPING,
                iconUrl = "https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                shortDescription = "Здесь покупаем"
            )
        )

        coEvery { repository.getApps() } returns expectedList

        val result = useCase.invoke()

        assertEquals(expectedList, result)
    }

    @Test
    fun `get home apps EXPECT empty list`() = runTest {
        coEvery { repository.getApps() } returns emptyList()

        val result = useCase.invoke()

        assertTrue(result.isEmpty())
    }

    @Test(expected = Exception::class)
    fun `get gome apps when repository fails EXPECT exception`() = runTest {
        coEvery { repository.getApps() } throws Exception("Network error")

        useCase.invoke()
    }
}