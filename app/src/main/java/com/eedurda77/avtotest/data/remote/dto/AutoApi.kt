package com.eedurda77.avtotest.data.remote.dto

import com.eedurda77.avtotest.data.remote.dto.autoinfo.AutoInfoDto
import com.eedurda77.avtotest.data.remote.dto.autos.AutoDtoItem
import com.eedurda77.avtotest.data.remote.dto.post.PostDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AutoApi {
    @GET("cars/list")
    suspend fun getAutos (
        @Query("page") page: Int,
        @Query("items") itemsInPage: Int
    ) : List<AutoDtoItem>

    @GET("car/{id}")
    suspend fun getAutoInfo (
        @Path("id") autoId: Int
    ) : AutoInfoDto

    @GET("car/{id}/posts")
    suspend fun getPosts (
        @Path("id") autoId: Int,
        @Query("page") page: Int,
        @Query("items") itemsInPage: Int
    ) : PostDto
}