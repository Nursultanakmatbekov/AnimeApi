package com.example.animeapi.data.remote.apiservices

import com.example.animeapi.data.models.AnimeResponse
import com.example.animeapi.data.models.DataItem
import com.example.animeapi.data.models.detail.AnimeDetail
import com.example.animeapi.data.models.pagination.Links
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiService {

    @GET("edge/anime")
    suspend fun fetchAnime(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): AnimeResponse<DataItem>

    @GET("edge/anime/{id}")
    suspend fun animeDetail(
        @Path("id") id: Int
    ): AnimeDetail
}