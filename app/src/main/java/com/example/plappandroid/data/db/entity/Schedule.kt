package com.example.plappandroid.data.db.entity

import androidx.room.Entity

@Entity(tableName = "schedule")
data class Schedule(
    val action: String,
    val additionalInfo: String,
    val date: String,
    val periodicity: Int,
    val plantId: Int,
    val userId: Int
)