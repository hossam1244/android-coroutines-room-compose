package com.hos.compose.coroutinesroomcompose.ui.screens.login_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hos.compose.coroutines_room_sample.ui.theme.*
import com.hos.compose.coroutinesroomcompose.R
import com.hos.compose.coroutinesroomcompose.ui.constants.*
import com.hos.compose.coroutinesroomcompose.ui.theme.TodoInputBarTextStyle


@Composable
fun LoginScreen(
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Login", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(24.dp))


            TextField(
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth(),
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(text = stringResource(id = R.string.email_hint))
                },
                singleLine = true,
            )


            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Handle login logic */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Login")
            }
        }
    }
}


