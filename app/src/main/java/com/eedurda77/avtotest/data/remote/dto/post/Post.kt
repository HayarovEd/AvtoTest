package com.eedurda77.avtotest.data.remote.dto.post


import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("author")
    val author: Author,
    @SerializedName("comment_count")
    val commentCount: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("img")
    val img: String,
    @SerializedName("like_count")
    val likeCount: Int,
    @SerializedName("text")
    val text: String
)