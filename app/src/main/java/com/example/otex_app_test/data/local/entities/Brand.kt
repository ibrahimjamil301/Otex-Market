package com.example.otex_app_test.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "brands")
data class Brand(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "",
    val  imageRes: Int = 0
)