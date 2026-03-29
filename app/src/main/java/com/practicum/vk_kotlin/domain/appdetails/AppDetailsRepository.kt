package com.practicum.vk_kotlin.domain.appdetails

import kotlinx.coroutines.flow.Flow

interface AppDetailsRepository {
    suspend fun get(id: String): AppDetails

    suspend fun toggleFavorite(id: String)

    fun observeAppDetails(id: String): Flow<AppDetails>
}