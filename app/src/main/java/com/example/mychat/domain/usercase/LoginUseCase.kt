package com.example.mychat.domain.usercase

import com.example.mychat.data.repository.AuthRepository

class LoginUseCase(
    private val repo : AuthRepository
) {
    suspend operator fun invoke(email: String,password: String): String{
        return repo.login(email,password)
    }

}