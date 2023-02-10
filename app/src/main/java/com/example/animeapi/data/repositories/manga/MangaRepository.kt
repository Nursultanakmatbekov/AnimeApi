package com.example.animeapi.data.repositories.manga

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.animeapi.base.BaseRepository
import com.example.animeapi.data.pagingsources.AnimePagingSource
import com.example.animeapi.data.pagingsources.MangaPagingSource
import com.example.animeapi.data.remote.apiservices.AnimeApiService
import com.example.animeapi.data.remote.apiservices.MangaApiService
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaApiService: MangaApiService,
) : BaseRepository() {

    fun fetchManga() =  Pager(
    PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        MangaPagingSource(mangaApiService)
    }.liveData

    fun mangaDetail(id: Int) = doRequest {
        mangaApiService.getSingleManga(id = id)
    }
}