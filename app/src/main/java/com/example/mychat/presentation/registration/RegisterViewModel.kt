package com.example.mychat.presentation.registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mychat.data.models.RegisterState
import com.example.mychat.domain.usercase.RegisterUseCase
import io.ktor.client.plugins.ClientRequestException
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val registerUseCase: RegisterUseCase,

    ) : ViewModel() {
    var state by mutableStateOf(RegisterState())
        private set

    fun onEmailChange(value: String) {
        state = state.copy(email = value, error = null)
    }

    fun onPasswordChange(value: String) {
        state = state.copy(password = value, error = null)
    }

    fun register() {
        viewModelScope.launch {
            state = state.copy(loading = true, error = null)
            try {
                if (state.email.isEmpty()&&state.password.isEmpty()){
                    state = state.copy(error = "Заполни поля с паролем")
                }else
                registerUseCase(
                    state.email,
                    state.password
                )
                state = state.copy(
                    loading = false,
                    success = true
                )
            } catch (e: ClientRequestException) {
                val message =
                    if (e.response.status == HttpStatusCode.Conflict) {
                        "Такой имэйл уже зарегестрирован"
                    } else
                        "ошибка сети"
                state = state.copy(
                    loading = false,
                    error = message
                )
            } catch (e: Exception) {

                state = state.copy(
                    loading = false,
                    error = "Такой имэйл уже зарегестрирован"
                )

            }
        }


    }
}
