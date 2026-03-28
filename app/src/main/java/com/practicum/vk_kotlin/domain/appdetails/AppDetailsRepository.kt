package com.practicum.vk_kotlin.domain.appdetails

interface AppDetailsRepository {
    suspend fun get(id: String): AppDetails
}