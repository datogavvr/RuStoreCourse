package com.practicum.vk_kotlin.domain

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatchers {
    fun default(): CoroutineDispatcher
    fun main(): CoroutineDispatcher
    fun io(): CoroutineDispatcher
    fun unconfined(): CoroutineDispatcher
}