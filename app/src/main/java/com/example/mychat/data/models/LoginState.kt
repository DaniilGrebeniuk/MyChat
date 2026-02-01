package com.example.mychat.data.models

data class LoginState(
    val email : String="",
    val password : String="",
    val isLoading : Boolean = false,
    val token : String? = null,
    val error : String? = null
)
