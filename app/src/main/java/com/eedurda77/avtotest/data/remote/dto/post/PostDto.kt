package com.eedurda77.avtotest.data.remote.dto.post


import com.google.gson.annotations.SerializedName

data class PostDto(
    @SerializedName("posts")
    val posts: List<Post>,
    @SerializedName("user")
    val postedUser: PostedUser
)