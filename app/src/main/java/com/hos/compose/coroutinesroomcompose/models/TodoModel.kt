package com.hos.compose.coroutines_room_sample.models

import java.util.UUID

data class TodoItem(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    var isDone: Boolean = false
)