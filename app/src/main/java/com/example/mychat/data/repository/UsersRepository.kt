package com.example.mychat.data.repository

import com.example.mychat.data.models.User
import com.example.mychat.network.api.UsersApi

class UsersRepository(
    private val api: UsersApi
) {
    suspend fun getUsers() : List<User> = api.getUsers()
}