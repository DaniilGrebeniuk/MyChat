package com.example.mychat.presentation.users

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mychat.data.models.UserState
import com.example.mychat.domain.usercase.GetUsersUseCase
import kotlinx.coroutines.launch

class UsersViewModel(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {
var state by mutableStateOf(UserState())
    private set
init {
    loadUsers()
}
    private fun loadUsers() {
        viewModelScope.launch {
            state =state.copy(loading = true)
            try {
                val users = getUsersUseCase()
                state= state.copy(
                    loading = false,
                    users = users
                )
            }catch (e: Exception){
                state =state.copy(
                    loading = false,
                    error = "Не удалось загрузить пользователей"
                )
            }
        }
    }
}