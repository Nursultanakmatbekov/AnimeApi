package com.example.animeapi.data.repositories.manga

import com.example.animeapi.base.BaseRepository
import com.example.animeapi.data.remote.apiservices.AnimeApiService
import com.example.animeapi.data.remote.apiservices.MangaApiService
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val animeApiService: AnimeApiService,
    private val mangaApiService: MangaApiService
) : BaseRepository() {

    fun fetchManga() = doRequest {
        mangaApiService.fetchManga()
    }

    fun mangaDetail(id: Int) = doRequest {
        mangaApiService.getSingleManga(id = id)
    }
}