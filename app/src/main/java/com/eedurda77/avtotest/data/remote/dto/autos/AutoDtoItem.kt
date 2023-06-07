package com.eedurda77.avtotest.data.remote.dto.autos


import com.google.gson.annotations.SerializedName

data class AutoDtoItem(
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
    @SerializedName("for_sale")
    val forSale: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("images")
    val images: List<Image>,
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
    val price: Double,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("transmission_id")
    val transmissionId: Int,
    @SerializedName("transmission_name")
    val transmissionName: String,
    @SerializedName("year")
    val year: Int
)