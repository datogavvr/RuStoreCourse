package com.practicum.vk_kotlin.domain.home

interface HomeRepository {
    suspend fun getApps(): List<HomeAppDetails>

}