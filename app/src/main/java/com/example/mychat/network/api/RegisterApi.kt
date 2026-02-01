package com.example.mychat.network.api

import androidx.compose.ui.autofill.ContentType
import com.example.mychat.data.models.LoginRequest
import com.example.mychat.data.models.RegisterRequest
import com.example.mychat.data.models.RegisterResponse
import com.example.mychat.network.ApiClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.contentType

class RegisterApi {
    suspend fun register(
        email: String,
        password: String
    ): Int {
        val response: RegisterResponse = ApiClient.client.post("http://10.0.2.2:8080/register") {
            contentType(io.ktor.http.ContentType.Application.Json)
            setBody(RegisterRequest(email, password))
        }.body()
        return response.id
    }

}
