package com.example.mychat.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    vm: LoginViewModel,
    onSuccess: (String) -> Unit,
    onRegisterClick: () -> Unit
) {
    val state = vm.state

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = state.email,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { vm.state = state.copy(email = it) },
            label = { Text("Email") })
        Spacer(Modifier.height(10.dp))
        TextField(
            value = state.password,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { vm.state = state.copy(password = it) },
            label = { Text("Password") })
        Spacer(Modifier.height(10.dp))

        Button(
            onClick = { vm.login() },
            Modifier.fillMaxWidth()
        ) { Text("Login") }
        TextButton(
            onClick = { onRegisterClick() },
            Modifier.fillMaxWidth()
        ) { Text("Нет акаунта , Зарегистрироваться?") }
        state.error?.let {
            Text(
                text = it,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                color = Color.Red
            )
        }
    }
    if (state.token != null) {
        onSuccess(state.token)
    }

}