package com.example.otex_app_test.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.otex_app_test.data.local.entities.Recommended
@Dao
interface RecommendedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(recommended: List<Recommended>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecommended(brand: Recommended)
    @Query("SELECT * FROM recommended")
    fun getAllRecommended(): LiveData<List<Recommended>>
    @Query("DELETE FROM recommended")
    suspend fun deleteAllRecommended()
    @Query("DELETE FROM recommended WHERE id = :recommendedId")
    suspend fun deleteRecommendedById(recommendedId: Int)
}
