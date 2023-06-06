package com.eedurda77.avtotest.data.repository

import com.eedurda77.avtotest.data.mapper.mapToAuto
import com.eedurda77.avtotest.data.remote.dto.AutoApi
import com.eedurda77.avtotest.domain.model.Auto
import com.eedurda77.avtotest.domain.model.AutoInfo
import com.eedurda77.avtotest.domain.model.PostAuto
import com.eedurda77.avtotest.domain.repository.RepositoryAuto
import com.eedurda77.avtotest.utils.Resource
import javax.inject.Inject

class RepositoryAutoImpl @Inject constructor(private val api: AutoApi) : RepositoryAuto {

    override suspend fun getAutos(page: Int, pageSize: Int): Resource<List<Auto>> {
        return try {
            Resource.Success(
                data = api.getAutos(
                    page = page,
                    itemsInPage = pageSize
                ).mapToAuto()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(message = e.message ?: "An unknown error")
        }
    }

    override suspend fun getAutoInfoById(id: Int): Resource<AutoInfo> {
        TODO("Not yet implemented")
    }

    override suspend fun getPostByAuto(
        autoId: Int,
        page: Int,
        pageSize: Int
    ): Resource<List<PostAuto>> {
        TODO("Not yet implemented")
    }

}