package com.example.otex_app_test.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.otex_app_test.data.local.entities.Filtering
@Dao
interface FilteringDao {
     @Query("SELECT * FROM filtering")
     fun getAllFiltering(): LiveData<List<Filtering>>
     @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
     suspend fun insertFiltering(filtering: List<Filtering>)
     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertFiltering(filtering: Filtering)
     @Query("SELECT COUNT(*) FROM filtering")
     suspend fun countFiltering(): Int
     @Query("SELECT * FROM filtering WHERE type = :type")
     fun getFilteringByType(type: String): LiveData<List<Filtering>>
}
