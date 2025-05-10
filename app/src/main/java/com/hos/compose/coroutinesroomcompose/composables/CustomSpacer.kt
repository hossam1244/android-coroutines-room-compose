package com.hos.compose.coroutinesroomcompose.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VerticalSpacer(
    height: Int
) {
   Spacer(
         modifier = Modifier.height(height.dp)
   )
}

@Composable
fun HorizontalSpacer(
    height: Int
) {
   Spacer(
         modifier = Modifier.width(height.dp)
   )
}