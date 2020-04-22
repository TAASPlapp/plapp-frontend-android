package com.example.plappandroid.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plant-type")
data class PlantType(
    val __v: Int,
    @PrimaryKey(autoGenerate = false)
    val _id: String,
    val description: String,
    val dprevention: String,
    val humidity: Int,
    val light: Int,
    val name: String,
    val sname: String,
    val temperature: Int,
    val treating: String,
    val wamount: Int,
    val watering: Int,
    val wiki: String
)