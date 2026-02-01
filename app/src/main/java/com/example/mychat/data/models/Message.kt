package com.example.mychat.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Message(
    val senderId: Int,
    val text: String,
    val timestamp: Long
)
