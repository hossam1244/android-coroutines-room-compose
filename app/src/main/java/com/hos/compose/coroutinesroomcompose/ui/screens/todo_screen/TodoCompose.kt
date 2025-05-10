package com.hos.compose.coroutinesroomcompose.ui.screens.todo_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import com.hos.compose.coroutinesroomcompose.composables.TodoInputBar
import com.hos.compose.coroutinesroomcompose.composables.TodoItemsContainer

import com.hos.compose.coroutinesroomcompose.ui.constants.OverlappingHeight
import com.hos.compose.coroutinesroomcompose.ui.screens.main_screen.MainViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoCompose(mainViewModel: MainViewModel) {
    return Box(
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