package com.practicum.vk_kotlin.data.home

import com.practicum.vk_kotlin.data.AppApi
import com.practicum.vk_kotlin.domain.home.HomeRepository
import com.practicum.vk_kotlin.domain.home.HomeAppDetails
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val appApi: AppApi,
    ) : HomeRepository {
    private val mapper = HomeAppDetailsMapper()

    override suspend fun getApps(): List<HomeAppDetails> {
        val dtoList = appApi.getAppsList()
        val domain = dtoList.map { mapper.toDomain(it) }
        return domain
    }
}