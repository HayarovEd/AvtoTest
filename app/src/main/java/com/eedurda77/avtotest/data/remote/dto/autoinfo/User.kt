package com.eedurda77.avtotest.data.remote.dto.autoinfo


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("about")
    val about: String,
    @SerializedName("auto_count")
    val autoCount: Int,
    @SerializedName("avatar")
    val avatar: Avatar,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main_auto_name")
    val mainAutoName: String,
    @SerializedName("username")
    val username: String
)