package com.practicum.vk_kotlin.domain.home

import javax.inject.Inject

class GetHomeAppsUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(): List<HomeAppDetails> {
        return homeRepository.getApps()
    }
}