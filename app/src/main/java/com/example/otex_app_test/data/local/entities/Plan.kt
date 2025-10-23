package com.example.otex_app_test.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plans")
data class Plan(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    val name: String,
    val price: String,
    val duration: String,
    val extraInfo: String = "",
    val extraInfo1: String = "",
    val tint1: String = "",
    val extraInfo2: String = "",
    val extraInfo3: String = "",
    val extraInfo4: String = "",
    val bonusNumber: String = "",
    val bonusText: String = "",
    val ratingTxt: String = ""
 )
