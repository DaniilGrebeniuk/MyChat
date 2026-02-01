package com.example.mychat.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mychat.data.auth.TokenStorage
import com.example.mychat.data.models.LoginState
import com.example.mychat.domain.usercase.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase

) : ViewModel() {
    var state by mutableStateOf(LoginState())



    fun login() {
        viewModelScope.launch {

            state = state.copy(isLoading = true)
            try {
                val token = loginUseCase(
                    state.email,
                    state.password
                )
                TokenStorage.token=token


                state = state.copy(isLoading = false, token = token)
            } catch (e: Exception) {
                state = state.copy(
                    isLoading = false,
                    error = " Введите мэйл и пароль"
                )

            }
        }
    }
}