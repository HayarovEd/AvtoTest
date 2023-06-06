package com.eedurda77.avtotest.domain.model

data class PostAuto(
    val id: Int,
    val pathPost: String,
    val datePost: String,
    val content: String,
    val likeCount: Int,
    val commentCount: Int
)
