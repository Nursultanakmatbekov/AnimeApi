package com.example.animeapi.data.repository

import com.example.animeapi.base.BaseRepository
import com.example.animeapi.data.remote.apisrvicec.AnimeApiService
import com.example.animeapi.data.remote.apisrvicec.MangaApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val animeApiService: AnimeApiService,
    private val mangaApiService: MangaApiService
) : BaseRepository() {

    fun fetchAnime() = doRequest {
        animeApiService.fetchAnime()
    }

    fun animeDetail(id: Int) = doRequest {
        animeApiService.animeDetail(id = id)
    }

    fun fetchManga() = doRequest {
        mangaApiService.fetchMangaById()
    }

    fun mangaDetail(id: Int) = doRequest {
        mangaApiService.getSingleManga(id = id)
    }
}