package com.example.animeapi.data.remote.apiservices

import com.example.animeapi.data.models.AnimeResponse
import com.example.animeapi.data.models.DataItem
import com.example.animeapi.data.models.detail.AnimeDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApiService {

    @GET("edge/manga")
    suspend fun fetchManga(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): AnimeResponse<DataItem>

    @GET("edge/manga/{id}")
    suspend fun getSingleManga(
        @Path("id") id: Int
    ): AnimeDetail
}