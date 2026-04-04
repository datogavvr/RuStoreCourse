package com.practicum.vk_kotlin.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDetailsDao {
    @Query("SELECT * FROM app_details WHERE id = :id")
    suspend fun getAppDetails(id: String): AppDetailsEntity?

    @Query("SELECT * FROM app_details WHERE id = :id")
    fun observeAppDetails(id: String): Flow<AppDetailsEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAppDetails(appDetails: AppDetailsEntity)

    @Query("UPDATE app_details SET isFavorite = not isFavorite WHERE id = :id")
    suspend fun toggleFavorite(id: String)
}