package com.eedurda77.avtotest.di

import com.eedurda77.avtotest.data.paginator.PaginatorDefault
import com.eedurda77.avtotest.data.remote.dto.post.Post
import com.eedurda77.avtotest.domain.model.Auto
import com.eedurda77.avtotest.domain.paginator.Paginator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PaginatorModule {
    @Binds
    @Singleton
    abstract fun bindPaginatorAuto(paginatorDefault:PaginatorDefault<Int, Auto>):Paginator<Int, Auto>

    @Binds
    @Singleton
    abstract fun bindPaginatorPost(paginatorDefault:PaginatorDefault<Int, Post>):Paginator<Int, Post>
}