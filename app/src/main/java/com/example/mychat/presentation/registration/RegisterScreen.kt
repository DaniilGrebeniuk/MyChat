package com.example.mychat.presentation.registration

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RegisterScreen(
    vm: RegisterViewModel,
    navController: NavController,
    onLoginClick: () -> Unit
) {
    val state = vm.state

    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Create account", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        TextField(
            value = state.email,
            onValueChange = vm::onEmailChange,
            Modifier.fillMaxWidth(),
            label = { Text("Email...") },
        )
        Spacer(Modifier.height(10.dp))

        TextField(
            value = state.password,
            onValueChange = vm::onPasswordChange,
            Modifier.fillMaxWidth(),
            label = { Text("Password...") },
        )
        Spacer(Modifier.height(16.dp))
        androidx.compose.material3.Button(
            onClick =  vm::register,

            Modifier.fillMaxWidth(),

            enabled = !state.loading
        ) { Text("Register") }
        Spacer(Modifier.height(10.dp))
        TextButton(
            onClick = onLoginClick
        ) { Text("Already have any account? Login") }


        if (state.error != null) {
            Text(
                text = state.error!!,
                color = Color.Red,
                modifier = Modifier.padding(8.dp)
            )
        }
        LaunchedEffect(state.success) {
            if (state.success){
                navController.popBackStack()
            state.copy(error = null)
            }
        }

    }
}