package com.example.animeapi.data.remote

import com.example.animeapi.data.remote.apiservices.AnimeApiService
import com.example.animeapi.data.remote.apiservices.MangaApiService
import com.example.animeapi.data.remote.apiservices.SignUpApiService
import com.example.animeapi.data.repositories.tokenInterceptor.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(TokenInterceptor())
        .addInterceptor(provideLoggingInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/edge/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideAnimeApiService() = retrofit.create(AnimeApiService::class.java)

    fun provideMangaApiService() = retrofit.create(MangaApiService::class.java)

    fun providerSignInApiService() = retrofit.create(SignUpApiService::class.java)
}