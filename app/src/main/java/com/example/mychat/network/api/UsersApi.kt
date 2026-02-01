package com.example.mychat.network.api

import com.example.mychat.data.models.User

interface UsersApi {
    suspend fun getUsers() : List<User>
}