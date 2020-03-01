package com.example.plappandroid.data.db.entity

import androidx.room.Entity

@Entity(tableName = "author")
data class Author(
    val bio: String,
    val birthdate: String,
    val firstName: String,
    val lastName: String,
    val profilePicture: String,
    val userId: Int,
    val username: String
)