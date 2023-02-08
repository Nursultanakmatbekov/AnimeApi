package com.example.animeapi.data.remote.apiservices

import com.example.animeapi.data.models.AnimeResponse
import com.example.animeapi.data.models.DataItem
import com.example.animeapi.data.models.detail.AnimeDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(): AnimeResponse<DataItem>

    @GET("anime/{id}")
    suspend fun animeDetail(
        @Path("id") id: Int
    ): AnimeDetail
}