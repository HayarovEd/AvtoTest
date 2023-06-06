package com.eedurda77.avtotest.data.remote.dto.autoinfo


import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("brand_id")
    val brandId: Int,
    @SerializedName("brand_name")
    val brandName: String,
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("country_name")
    val countryName: String,
    @SerializedName("engine")
    val engine: String,
    @SerializedName("engine_id")
    val engineId: Int,
    @SerializedName("engine_name")
    val engineName: String,
    @SerializedName("engine_volume")
    val engineVolume: String,
    @SerializedName("follow")
    val follow: Boolean,
    @SerializedName("followers_count")
    val followersCount: Int,
    @SerializedName("for_sale")
    val forSale: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("images")
    val images: List<ImageAuto>,
    @SerializedName("in_selection_count")
    val inSelectionCount: Int,
    @SerializedName("is_moderated")
    val isModerated: Boolean,
    @SerializedName("model_id")
    val modelId: Int,
    @SerializedName("model_name")
    val modelName: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("place_id")
    val placeId: String,
    @SerializedName("place_name")
    val placeName: String,
    @SerializedName("price")
    val price: Any,
    @SerializedName("transmission_id")
    val transmissionId: Int,
    @SerializedName("transmission_name")
    val transmissionName: String,
    @SerializedName("year")
    val year: Int
)