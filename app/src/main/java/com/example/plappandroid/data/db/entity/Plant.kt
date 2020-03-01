package com.example.plappandroid.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.plappandroid.data.db.StatusConverter

@Entity(tableName = "plant")
data class Plant(
    val plantId: Long,
    val owner: Long,
    val name: String,
    val description: String,
    val type: String,

    @ColumnInfo(name = "status")
    @TypeConverters(StatusConverter::class)
    val status: HealthStatus?,
    val image: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
