package com.example.mychat.network.api

import com.example.mychat.data.models.LoginRequest
import com.example.mychat.data.models.LoginResponse
import com.example.mychat.network.ApiClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.contentType

class AuthApi {
    suspend fun login(email: String, password: String): String {
        val response: LoginResponse = ApiClient.client.post("http://10.0.2.2:8080/login")
        {
            contentType(io.ktor.http.ContentType.Application.Json)
            setBody(LoginRequest(email, password))
        }.body()
        return response.token
    }
}