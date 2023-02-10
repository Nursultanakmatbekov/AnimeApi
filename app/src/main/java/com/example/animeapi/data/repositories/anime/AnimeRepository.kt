package com.example.animeapi.data.repositories.anime

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.animeapi.base.BaseRepository
import com.example.animeapi.data.pagingsources.AnimePagingSource
import com.example.animeapi.data.remote.apiservices.AnimeApiService
import com.example.animeapi.data.remote.apiservices.MangaApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val animeApiService: AnimeApiService,
) : BaseRepository() {

    fun fetchAnime()  = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        AnimePagingSource(animeApiService)
    }.liveData

    fun animeDetail(id: Int) = doRequest {
        animeApiService.animeDetail(id = id)
    }
}