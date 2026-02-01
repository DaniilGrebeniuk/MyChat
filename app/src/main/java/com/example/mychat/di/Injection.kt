package com.example.mychat.di

import com.example.mychat.data.repository.AuthRepository
import com.example.mychat.data.repository.RegisterRepository
import com.example.mychat.data.repository.UsersRepository
import com.example.mychat.domain.usercase.GetUsersUseCase
import com.example.mychat.domain.usercase.LoginUseCase
import com.example.mychat.domain.usercase.RegisterUseCase
import com.example.mychat.network.ApiClient
import com.example.mychat.network.api.AuthApi
import com.example.mychat.network.api.RegisterApi
import com.example.mychat.network.api.UsersApi
import com.example.mychat.network.api.UsersApiImpl
import com.example.mychat.presentation.login.LoginViewModel
import com.example.mychat.presentation.registration.RegisterViewModel
import com.example.mychat.presentation.users.UsersViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object Injection {

    private val authApi = AuthApi()
    private val registerApi = RegisterApi()
    private val usersApi = UsersApiImpl(ApiClient.client)

    private val authRepo = AuthRepository(authApi)
    private val registerRepo = RegisterRepository(registerApi)
private val usersRepo = UsersRepository(usersApi)
    private val loginUseCase = LoginUseCase(authRepo)
    private val registerUseCase = RegisterUseCase(registerRepo)

    private val getUsersUseCase = GetUsersUseCase(usersRepo)

    fun loginViewModel() = LoginViewModel(loginUseCase)
    fun registerViewModel() = RegisterViewModel(registerUseCase)

    fun usersViewModel() = UsersViewModel(getUsersUseCase)

}