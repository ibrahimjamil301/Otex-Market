package com.example.otex_app_test.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.otex_app_test.data.local.entities.Item
@Dao
interface ItemDao {
    @Query("SELECT * FROM items")
    fun getAllItems(): LiveData<List<Item>>
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertItems(items: List<Item>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Item)
    @Query("SELECT COUNT(*) FROM items")
    suspend fun countItems(): Int
}

