package com.practicum.vk_kotlin.data.appdetails

import com.practicum.vk_kotlin.data.AppApi
import com.practicum.vk_kotlin.domain.appdetails.AppDetails
import com.practicum.vk_kotlin.domain.appdetails.AppDetailsRepository


class AppDetailsRepositoryImpl : AppDetailsRepository {
    private val appApi = AppApi()
    private val mapper = AppDetailsMapper()

    override suspend fun get(): AppDetails {
        val dto = appApi.getAppDetails()
        val domain = mapper.toDomain(dto)
        return domain
    }
}