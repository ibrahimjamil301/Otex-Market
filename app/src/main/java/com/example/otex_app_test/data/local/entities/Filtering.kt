package com.example.otex_app_test.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "filtering")
data class Filtering( @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val type: String
)
