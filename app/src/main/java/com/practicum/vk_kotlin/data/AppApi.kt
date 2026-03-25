package com.practicum.vk_kotlin.data

import com.practicum.vk_kotlin.data.appdetails.AppDetailsDto
import com.practicum.vk_kotlin.data.home.HomeAppDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface AppApi {
    @GET("catalog/{id}")
    suspend fun getAppDetails(@Path("id") id: String): AppDetailsDto

    @GET("catalog")
    suspend fun getAppsList(): List<HomeAppDetailsDto>
}