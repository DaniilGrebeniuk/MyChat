package com.example.mychat.presentation.users

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mychat.di.Injection

@Composable
fun UserScreen(
    navController: NavController,
    vM: UsersViewModel = remember{Injection.usersViewModel()}
) {
    val state = vM.state
    Box(Modifier.fillMaxSize()){
        when {
            state.loading -> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }

            state.error != null -> {
                Text(
                    text = state.error,
                    color = Color.Red,
                    modifier = Modifier.padding(16.dp)
                )
            }

            else -> {
                LazyColumn {
                    items(state.users) { user ->
                        UserItem(user) {
                            navController.navigate("chat/${user.id}")
                        }
                    }
                }
            }
        }
    }

}