package com.eedurda77.avtotest.di

import com.eedurda77.avtotest.data.repository.RepositoryAutoImpl
import com.eedurda77.avtotest.domain.repository.RepositoryAuto
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepository(
        repositoryImpl: RepositoryAutoImpl
    ): RepositoryAuto
}