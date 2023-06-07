package com.eedurda77.avtotest.di

import com.eedurda77.avtotest.data.remote.dto.AutoApi
import com.eedurda77.avtotest.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {
    @Provides
    @Singleton
    fun provideApi(): AutoApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AutoApi::class.java)
    }
}