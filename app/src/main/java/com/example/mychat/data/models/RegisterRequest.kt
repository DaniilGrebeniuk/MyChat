package com.example.mychat.data.models

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    val email : String,
    val password: String
)
