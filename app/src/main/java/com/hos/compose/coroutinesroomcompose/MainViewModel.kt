package com.hos.compose.coroutinesroomcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hos.compose.coroutinesroomcompose.data.models.TodoItem
import com.hos.compose.coroutinesroomcompose.repository.TodoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class MainViewModel(
    // 1. ViewModel Initialization
    private val repository: TodoRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    /// TODO: Lesson -> The repository provides access to the data layer, allowing the ViewModel to perform database operations through it
    /// TODO: Lesson -> The CoroutineDispatcher, typically Dispatchers.IO for database operations, is used to ensure these operations are executed on a background thread, keeping the UI thread free from blocking operations. This setup effectively separates the concerns of data management and UI logic
    /// TODO: Lesson -> Flow establishes a reactive data stream, where updates in the database are automatically reflected in the UI. The use of Kotlin's Flow ensures asynchronous data handling and lifecycle-aware updates, making the UI responsive and up-to-date with the latest data without manual refreshes

    // 2. Todo Data Flow
    val todos = repository.allTodos

    // 3. Todo Operations
    fun addTodo(todo: String) =
        viewModelScope.launch(ioDispatcher) { repository.insert(TodoItem(title = todo)) }

    fun toggleTodo(todoItem: TodoItem) =
        viewModelScope.launch(ioDispatcher) { repository.insert(todoItem.copy(isDone = !todoItem.isDone)) }

    fun removeTodo(todoItem: TodoItem) =
        viewModelScope.launch(ioDispatcher) { repository.delete(todoItem) }
}