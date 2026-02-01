package com.example.mychat.data.repository

import com.example.mychat.network.api.AuthApi

class AuthRepository(
    private val authApi: AuthApi,
) {
    suspend fun login(email: String, password: String) =
        authApi.login(email, password)

    }