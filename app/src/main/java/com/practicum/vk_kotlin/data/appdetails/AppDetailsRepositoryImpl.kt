package com.practicum.vk_kotlin.data.appdetails

import com.practicum.vk_kotlin.data.AppApi
import com.practicum.vk_kotlin.domain.appdetails.AppDetails
import com.practicum.vk_kotlin.domain.appdetails.AppDetailsRepository
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val appApi: AppApi
) : AppDetailsRepository {
    private val mapper = AppDetailsMapper()

    override suspend fun get(id: String): AppDetails {
        val dto = appApi.getAppDetails(id)
        val domain = mapper.toDomain(dto)
        return domain
    }
}