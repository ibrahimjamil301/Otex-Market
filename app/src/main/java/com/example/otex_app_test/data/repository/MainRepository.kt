package com.example.otex_app_test.data.repository

import com.example.otex_app_test.data.local.entities.Item
import com.example.otex_app_test.data.local.AppDatabase
import com.example.otex_app_test.data.local.entities.Brand
import com.example.otex_app_test.data.local.entities.Filtering
import com.example.otex_app_test.data.local.entities.Plan
import com.example.otex_app_test.data.local.entities.Recommended
class MainRepository(private val db: AppDatabase) {
    fun getAllItems() = db.itemDao().getAllItems()
    suspend fun insertItems(items: List<Item>) {
        db.itemDao().insertItems(items)
    }
    fun getAllBrands() = db.BrandDao().getAllBrands()
    suspend fun insertBrands(brands: List<Brand>) {
        db.BrandDao().insertAll(brands)
    }
    fun getAllPlans() = db.PlanDao().getAllPlans()

    suspend fun insertPlans(plans: List<Plan>) {
        db.PlanDao().insertAll(plans)
    }
    fun getAllRecommended() = db.RecommendedDao().getAllRecommended()
    suspend fun insertRecommended(recommended: List<Recommended>) {
        db.RecommendedDao().insertAll(recommended)
    }
    fun getAllFiltering() = db.FilteringDao().getAllFiltering()
    suspend fun insertFiltering(filtering: List<Filtering>) {
        db.FilteringDao().insertFiltering(filtering)
    }
    fun getFilteringByType(type: String) = db.FilteringDao().getFilteringByType(type)
}


