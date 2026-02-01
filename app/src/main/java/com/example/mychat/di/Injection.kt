package com.example.mychat.di

import com.example.mychat.data.repository.AuthRepository
import com.example.mychat.data.repository.RegisterRepository
import com.example.mychat.domain.usercase.LoginUseCase
import com.example.mychat.domain.usercase.RegisterUseCase
import com.example.mychat.network.api.AuthApi
import com.example.mychat.network.api.RegisterApi
import com.example.mychat.presentation.login.LoginViewModel
import com.example.mychat.presentation.registration.RegisterViewModel

object Injection {
    private val authApi = AuthApi()
    private val registerApi = RegisterApi()

    private val authRepo = AuthRepository(authApi)
    private val registerRepo = RegisterRepository(registerApi)

    private val loginUseCase = LoginUseCase(authRepo)
    private val registerUseCase = RegisterUseCase(registerRepo)


    fun loginViewModel() = LoginViewModel(loginUseCase)
    fun registerViewModel() = RegisterViewModel(registerUseCase)

}