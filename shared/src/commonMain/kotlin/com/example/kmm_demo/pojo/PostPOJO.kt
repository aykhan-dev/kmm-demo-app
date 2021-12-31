package com.example.kmm_demo.pojo

import kotlinx.serialization.Serializable

@Serializable
data class PostPOJO(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
)