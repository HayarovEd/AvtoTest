package com.eedurda77.avtotest.domain.model

data class AutoInfo(
    val id: Int,
    val name: String,
    val brandName: String,
    val modelName: String,
    val year: Int,
    val transmissionName: String,
    val engine: String,
    val pathImage: String,
    val userName:String,
    val pathAvatar:String
)
