package com.practicum.vk_kotlin.di

import android.content.Context
import androidx.room.Room
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.practicum.vk_kotlin.data.AppApi
import com.practicum.vk_kotlin.data.appdetails.AppDetailsMapper
import com.practicum.vk_kotlin.data.local.AppDatabase
import com.practicum.vk_kotlin.data.local.AppDetailsDao
import com.practicum.vk_kotlin.data.local.AppDetailsEntityMapper
import com.practicum.vk_kotlin.domain.appdetails.AppDetailsRepository
import com.practicum.vk_kotlin.domain.appdetails.GetAppDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json {
            ignoreUnknownKeys = true
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit(json: Json): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://185.103.109.134")
            .addConverterFactory(json
                .asConverterFactory("application/json".toMediaType())
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideAppApi(retrofit: Retrofit): AppApi {
        return retrofit.create(AppApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGetAppDetailsUseCase(repository: AppDetailsRepository): GetAppDetailsUseCase {
        return GetAppDetailsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAppDetailsMapper(): AppDetailsMapper {
        return AppDetailsMapper()
    }

    @Provides
    @Singleton
    fun provideAppDetailsEntityMapper(): AppDetailsEntityMapper {
        return AppDetailsEntityMapper()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideAppDetailsDao(database: AppDatabase): AppDetailsDao {
        return database.appDetailsDao()
    }
}