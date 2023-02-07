package com.example.animeapi.di

import com.example.animeapi.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun retrofitClient() = RetrofitClient()

    @Provides
    @Singleton
    fun provideAnimeApiService(retrofitClient: RetrofitClient) = retrofitClient.provideAnimeApiService()

    @Provides
    @Singleton
    fun provideMangaApiService(retrofitClient: RetrofitClient) = retrofitClient.provideMangaApiService()
}