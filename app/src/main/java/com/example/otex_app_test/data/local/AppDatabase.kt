package com.example.otex_app_test.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.otex_app_test.data.local.dao.BrandDao
import com.example.otex_app_test.data.local.dao.FilteringDao
import com.example.otex_app_test.data.local.dao.ItemDao
import com.example.otex_app_test.data.local.dao.PlanDao
import com.example.otex_app_test.data.local.dao.RecommendedDao
import com.example.otex_app_test.data.local.entities.Brand
import com.example.otex_app_test.data.local.entities.Filtering
import com.example.otex_app_test.data.local.entities.Item
import com.example.otex_app_test.data.local.entities.Plan
import com.example.otex_app_test.data.local.entities.Recommended
@Database(entities = [
    Item::class,
    Brand::class,
    Recommended::class,
    Plan::class,
    Filtering::class],
    version = 18,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
    abstract fun BrandDao(): BrandDao
    abstract fun RecommendedDao(): RecommendedDao
    abstract fun PlanDao(): PlanDao
    abstract fun FilteringDao(): FilteringDao
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
