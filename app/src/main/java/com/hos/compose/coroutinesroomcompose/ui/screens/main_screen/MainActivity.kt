package com.hos.compose.coroutinesroomcompose.ui.screens.main_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.hos.compose.coroutinesroomcompose.composables.TodoInputBar
import com.hos.compose.coroutinesroomcompose.composables.TodoItemsContainer
import com.hos.compose.coroutinesroomcompose.data.models.TodoItem
import com.hos.compose.coroutinesroomcompose.data.room.AppDatabase
import com.hos.compose.coroutinesroomcompose.repository.TodoRepository
import com.hos.compose.coroutinesroomcompose.ui.constants.OverlappingHeight
import com.hos.compose.coroutinesroomcompose.ui.theme.CoroutinesroomsampleTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf

// TODO
// 1. DATA STORE
// 2. WORK MANAGER
// 3. RETROFIT
// 4. COMPOSE UI
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. Manual DB Creation
        val db = Room
            .databaseBuilder(applicationContext, AppDatabase::class.java, "todo-db")
            .build()
        // 2. Manual MainViewModel Creation
        val mainViewModel = MainViewModel(TodoRepository(db.todoDao()), ioDispatcher = Dispatchers.IO)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                TodoItemsContainer(
                    todoItemsFlow = mainViewModel.todos,
                    // 3. Method Reference Expression
                    onItemClick = mainViewModel::toggleTodo,
                    onItemDelete = mainViewModel::removeTodo,
                    overlappingElementsHeight = OverlappingHeight
                )
                TodoInputBar(
                    modifier = Modifier.align(Alignment.BottomStart),
                    onAddButtonClick = mainViewModel::addTodo
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoroutinesroomsampleTheme {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            TodoItemsContainer(
                // 1. Mock Data for Todo Items
                todoItemsFlow = flowOf(
                    listOf(
                        TodoItem(title = "Todo Item 1"),
                        TodoItem(title = "Todo Item 2", isDone = true),
                        TodoItem(title = "Todo Item 3"),
                        TodoItem(title = "Todo Item 4", isDone = true),
                        TodoItem(title = "Todo Item 5"),
                        TodoItem(title = "Todo Item 6"),
                        TodoItem(title = "Todo Item 7"),
                        TodoItem(title = "Todo Item 8"),
                        TodoItem(title = "Todo Item 9"),
                        TodoItem(title = "Todo Item 10"),
                        TodoItem(title = "Todo Item 11", isDone = true),
                        TodoItem(title = "Todo Item 12"),
                        TodoItem(title = "Todo Item 13"),
                        TodoItem(title = "Todo Item 14"),
                        TodoItem(title = "Todo Item 15")
                    )
                ),
                onItemClick = {},
                onItemDelete = {},
                // 2. Space Adjustment for Overlapping UI Elements
                overlappingElementsHeight = OverlappingHeight
            )
            TodoInputBar(
                modifier = Modifier.align(Alignment.BottomStart),
                onAddButtonClick = {}
            )
        }
    }
}