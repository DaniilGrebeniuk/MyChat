package com.example.mychat.data.models

data class RegisterState(
    val email: String="",
    val password: String="",
    val loading: Boolean = false,
    val success: Boolean = false,
    val error : String? = null
)
