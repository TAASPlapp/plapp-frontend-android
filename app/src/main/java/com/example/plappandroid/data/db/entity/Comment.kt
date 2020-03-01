package com.example.plappandroid.data.db.entity

import androidx.room.Embedded
import androidx.room.Entity

@Entity(tableName = "comment")
data class Comment(
    @Embedded(prefix = "author_")
    val author: Author,
    val content: String,
    val id: Int,
    val itemId: Int,
    val mediaContentType: String,
    val publishedAt: String
)