package com.hos.compose.coroutinesroomcompose.models

import java.util.UUID

data class TodoItem(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    var isDone: Boolean = false
)