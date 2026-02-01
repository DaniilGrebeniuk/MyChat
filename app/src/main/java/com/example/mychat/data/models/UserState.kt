package com.example.mychat.data.models

data class UserState(
    val loading : Boolean = false,
    val users : List<User> = emptyList(),
    val error : String? =null
)
