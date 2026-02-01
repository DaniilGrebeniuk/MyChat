package com.example.mychat.domain.usercase

import com.example.mychat.data.repository.AuthRepository
import com.example.mychat.data.repository.RegisterRepository

class RegisterUseCase(private val repo: RegisterRepository) {
    suspend operator fun invoke(email: String, password: String): Int {
        return repo.register(email, password)
    }

}