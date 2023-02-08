package com.example.animeapi.data.repositories.anime

import com.example.animeapi.base.BaseRepository
import com.example.animeapi.data.remote.apiservices.AnimeApiService
import com.example.animeapi.data.remote.apiservices.MangaApiService
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
}