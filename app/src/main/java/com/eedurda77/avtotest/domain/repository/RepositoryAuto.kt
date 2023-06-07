package com.eedurda77.avtotest.domain.repository

import com.eedurda77.avtotest.domain.model.Auto
import com.eedurda77.avtotest.domain.model.AutoInfo
import com.eedurda77.avtotest.domain.model.PostAuto
import com.eedurda77.avtotest.utils.Resource

interface RepositoryAuto {
    suspend fun getAutos(page: Int, pageSize: Int): Resource<List<Auto>>
    suspend fun getAutoInfoById(id: Int): Resource<AutoInfo>
    suspend fun getPostByAuto(autoId: Int, page: Int, pageSize: Int): Resource<List<PostAuto>>
}