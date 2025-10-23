package com.example.otex_app_test.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.otex_app_test.data.local.entities.Plan
@Dao
interface PlanDao {
    @Query("SELECT * FROM plans")
    fun getAllPlans(): LiveData<List<Plan>>
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertAll(plans: List<Plan>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlan(plan: Plan)
    @Query("SELECT COUNT(*) FROM plans")
    suspend fun countPlans(): Int
}
