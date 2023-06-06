package com.eedurda77.avtotest.data.remote.dto.post


import com.google.gson.annotations.SerializedName

data class PostedUser(
    @SerializedName("auto_count")
    val autoCount: Int,
    @SerializedName("avatar")
    val avatar: Avatar,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main_auto_name")
    val mainAutoName: String,
    @SerializedName("username")
    val username: String
)