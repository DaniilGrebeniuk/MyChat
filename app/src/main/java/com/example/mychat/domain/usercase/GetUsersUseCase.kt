package com.example.mychat.domain.usercase

import com.example.mychat.data.models.User
import com.example.mychat.data.repository.UsersRepository

class GetUsersUseCase(
    private val repository: UsersRepository
) {
    suspend operator fun invoke(): List<User> = repository.getUsers()
}