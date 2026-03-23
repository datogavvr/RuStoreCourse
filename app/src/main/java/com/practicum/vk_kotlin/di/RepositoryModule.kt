package com.practicum.vk_kotlin.di

import com.practicum.vk_kotlin.data.appdetails.AppDetailsRepositoryImpl
import com.practicum.vk_kotlin.data.home.HomeRepositoryImpl
import com.practicum.vk_kotlin.domain.appdetails.AppDetailsRepository
import com.practicum.vk_kotlin.domain.home.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindAppDetailsRepository(impl: AppDetailsRepositoryImpl): AppDetailsRepository

    @Binds
    fun bindHomeRepository(impl: HomeRepositoryImpl): HomeRepository
}