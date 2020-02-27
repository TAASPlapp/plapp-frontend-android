package com.example.plappandroid.models

data class Plant(
    val plantId: Long,
    val owner: Long,
    val name: String,
    val description: String,
    val type: String,
    val status: HealthStatus,
    val image: String
) {
}