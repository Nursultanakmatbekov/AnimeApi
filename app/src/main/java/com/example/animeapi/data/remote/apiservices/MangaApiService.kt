package com.example.animeapi.data.remote.apiservices

import com.example.animeapi.data.models.AnimeResponse
import com.example.animeapi.data.models.DataItem
import com.example.animeapi.data.models.detail.AnimeDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface MangaApiService {

    @GET("manga")
    suspend fun fetchManga(): AnimeResponse<DataItem>

    @GET("manga/{id}")
    suspend fun getSingleManga(
        @Path("id") id: Int
    ): AnimeDetail
}