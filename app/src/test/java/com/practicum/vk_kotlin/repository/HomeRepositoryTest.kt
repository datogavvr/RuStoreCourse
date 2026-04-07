package com.practicum.vk_kotlin.repository

import com.practicum.vk_kotlin.data.AppApi
import com.practicum.vk_kotlin.data.home.HomeAppDetailsDto
import com.practicum.vk_kotlin.data.home.HomeRepositoryImpl
import com.practicum.vk_kotlin.domain.appdetails.Category
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class HomeRepositoryTest {
    val api: AppApi = mockk()
    val repository = HomeRepositoryImpl(api)

    @Test
    fun `getApps EXPECT list of home apps`() = runTest {
        val expectedList = listOf(
            HomeAppDetailsDto(
                id = "123",
                name = "VK",
                category = Category.SOCIAL,
                iconUrl = "https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                shortDescription = "Здесь переписываемся"
            ),
            HomeAppDetailsDto(
                id = "125",
                name = "Ozon",
                category = Category.SHOPPING,
                iconUrl = "https://images.unsplash.com/photo-1574144611937-0df059b5ef3e?q=80&w=1528&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                shortDescription = "Здесь покупаем"
            )
        )

        coEvery { api.getAppsList() } returns expectedList

        val result = repository.getApps()

        assertEquals(2, result.size)
        assertEquals("123", result[0].id)
    }
}