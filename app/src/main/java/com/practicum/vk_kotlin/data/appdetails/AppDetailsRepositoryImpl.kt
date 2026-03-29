package com.practicum.vk_kotlin.data.appdetails

import com.practicum.vk_kotlin.data.AppApi
import com.practicum.vk_kotlin.data.local.AppDetailsDao
import com.practicum.vk_kotlin.data.local.AppDetailsEntityMapper
import com.practicum.vk_kotlin.domain.appdetails.AppDetails
import com.practicum.vk_kotlin.domain.appdetails.AppDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val appApi: AppApi,
    private val mapper: AppDetailsMapper,
    private val dbMapper: AppDetailsEntityMapper,
    private val dao: AppDetailsDao
) : AppDetailsRepository {

    override suspend fun get(id: String): AppDetails {
        val entity = dao.getAppDetails(id)

        return if (entity != null) {
            dbMapper.toDomain(entity)
        } else {
            val domain = mapper.toDomain(appApi.getAppDetails(id))
            dao.insertAppDetails(dbMapper.toEntity(domain))
            domain
        }
    }

    override suspend fun toggleFavorite(id: String) {
        dao.toggleFavorite(id)
    }

    override fun observeAppDetails(id: String): Flow<AppDetails> {
        return dao.observeAppDetails(id)
            .filterNotNull()
            .map { dbMapper.toDomain(it) }
    }
}