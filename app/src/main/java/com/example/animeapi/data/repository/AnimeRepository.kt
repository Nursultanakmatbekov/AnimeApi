package com.example.animeapi.data.repository

import androidx.lifecycle.liveData
import com.example.animeapi.data.remote.apisrvicec.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val apiService: AnimeApiService) {

    fun fetchAnime() = liveData {
        emit(apiService.fetchAnime())
    }

    fun animeDetail(id: Int) = liveData {
        emit(apiService.animeDetail(id))
    }
}