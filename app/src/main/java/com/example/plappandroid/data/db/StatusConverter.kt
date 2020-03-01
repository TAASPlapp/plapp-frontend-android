package com.example.plappandroid.data.db

import androidx.room.TypeConverter
import com.example.plappandroid.data.db.entity.HealthStatus

object StatusConverter {

    @TypeConverter
    @JvmStatic
    fun toHealth(value: String) = enumValueOf<HealthStatus>(value)

    @TypeConverter
    @JvmStatic
    fun fromHealth(value: HealthStatus?) : String {
        if (value != null) {
            return value.name
        }
        return HealthStatus.Healthy.toString()
    }
}