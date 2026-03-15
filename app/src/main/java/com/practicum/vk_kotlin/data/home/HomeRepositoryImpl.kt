package com.practicum.vk_kotlin.data.home

import com.practicum.vk_kotlin.data.AppApi
import com.practicum.vk_kotlin.domain.home.HomeRepository
import com.practicum.vk_kotlin.domain.home.ShortAppDetails

class HomeRepositoryImpl : HomeRepository {
    private val appApi = AppApi()
    private val mapper = ShortAppDetailsMapper()

    override suspend fun getApps(): List<ShortAppDetails> {
        val dtoList = appApi.getAppsList()
        val domain = dtoList.map { mapper.toDomain(it) }
        return domain
    }
}