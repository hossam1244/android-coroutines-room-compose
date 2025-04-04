package com.hos.compose.coroutinesroomcompose.data.room

import androidx.room.*
import com.hos.compose.coroutinesroomcompose.data.models.TodoItem
import kotlinx.coroutines.flow.Flow

// 1. Dao Annotation
@Dao
interface TodoDao {
    // 2. Items Flow
    @Query("SELECT * FROM TodoItem")
    fun getAllTodos(): Flow<List<TodoItem>>

    // 3. Insert Operation for Adding or Updating Items
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: TodoItem)

    // 4. Delete an Item by TodoItem.id
    @Delete
    suspend fun delete(todo: TodoItem)
}