package com.hos.compose.coroutinesroomcompose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    var isDone: Boolean = false
)