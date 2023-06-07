package com.eedurda77.avtotest.data.remote.dto.autoinfo


import com.google.gson.annotations.SerializedName

data class AutoInfoDto(
    @SerializedName("car")
    val car: Car,
    @SerializedName("user")
    val user: User
)