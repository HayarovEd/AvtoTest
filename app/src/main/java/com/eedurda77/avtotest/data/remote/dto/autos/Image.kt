package com.eedurda77.avtotest.data.remote.dto.autos


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image100")
    val image100: String,
    @SerializedName("image500")
    val image500: String,
    @SerializedName("index")
    val index: Int,
    @SerializedName("is_primary")
    val isPrimary: Boolean,
    @SerializedName("size")
    val size: Int,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @SerializedName("url")
    val url: String
)