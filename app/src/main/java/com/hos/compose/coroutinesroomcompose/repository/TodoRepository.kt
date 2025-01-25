package com.hos.compose.coroutinesroomcompose.repository

import com.hos.compose.coroutinesroomcompose.data.models.TodoItem
import com.hos.compose.coroutinesroomcompose.data.room.TodoDao
import kotlinx.coroutines.flow.Flow

// 1. Repository Initialization
class TodoRepository(private val todoDao: TodoDao) {
    // 2. Data Retrieval
    val allTodos: Flow<List<TodoItem>> = todoDao.getAllTodos()

    // 3. Data Modification Methods
    suspend fun insert(todo: TodoItem) {
        todoDao.insert(todo)
    }

    suspend fun delete(todo: TodoItem) {
        todoDao.delete(todo)
    }

    /***
     *  Being suspend functions, they are designed to be called from a coroutine,
     *  ensuring that these database operations are performed without blocking the main thread,
     *  thus maintaining a smooth user experience
     */
}