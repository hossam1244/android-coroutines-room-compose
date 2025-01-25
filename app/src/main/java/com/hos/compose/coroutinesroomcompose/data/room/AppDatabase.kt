package com.hos.compose.coroutinesroomcompose.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hos.compose.coroutinesroomcompose.data.models.TodoItem

// 1. Database Annotation
@Database(entities = [TodoItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    // 2. Abstract Functions
    abstract fun todoDao(): TodoDao
}