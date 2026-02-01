package com.example.mychat.network.api

import com.example.mychat.data.auth.TokenStorage
import com.example.mychat.data.models.User
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders

class UsersApiImpl(
    private val client: HttpClient
) : UsersApi {
    override suspend fun getUsers(): List<User> {
        return client.get("http://10.0.2.2:8080/users"  ){
            header(HttpHeaders.Authorization,"Bearer ${TokenStorage.token}")
        }.body()
    
    }
}