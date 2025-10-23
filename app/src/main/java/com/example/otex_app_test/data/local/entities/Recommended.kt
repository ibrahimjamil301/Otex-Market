package com.example.otex_app_test.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "recommended")
data class Recommended(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val  images: Int = 0
)