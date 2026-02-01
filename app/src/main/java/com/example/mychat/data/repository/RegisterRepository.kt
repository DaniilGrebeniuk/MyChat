package com.example.mychat.data.repository

import com.example.mychat.data.models.RegisterRequest
import com.example.mychat.network.api.RegisterApi

class RegisterRepository(
    private val registerApi: RegisterApi

) {
    suspend fun register(email: String, password: String) : Int {
     return  registerApi.register(email, password)
    }
}

