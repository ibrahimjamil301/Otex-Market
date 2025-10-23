package com.example.otex_app_test.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.otex_app_test.data.local.entities.Brand
@Dao
interface BrandDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(brands: List<Brand>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBrand(brand: Brand)
    @Query("SELECT * FROM brands")
    fun getAllBrands(): LiveData<List<Brand>>
    @Query("DELETE FROM brands")
    suspend fun deleteAllBrands()
    @Query("DELETE FROM brands WHERE id = :brandId")
    suspend fun deleteBrandById(brandId: Int)
}
