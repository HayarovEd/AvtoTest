package com.eedurda77.avtotest.data.remote.dto.autoinfo


import com.google.gson.annotations.SerializedName

data class Avatar(
    @SerializedName("path")
    val path: String,
    @SerializedName("url")
    val url: String
)