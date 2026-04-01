package com.practicum.vk_kotlin.di

import com.practicum.vk_kotlin.data.CoroutineDispatchersImpl
import com.practicum.vk_kotlin.domain.CoroutineDispatchers
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DispatchersModule {
    @Binds
    fun bindDispatchers(impl: CoroutineDispatchersImpl): CoroutineDispatchers
}