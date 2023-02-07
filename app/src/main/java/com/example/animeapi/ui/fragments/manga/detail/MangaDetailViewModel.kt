package com.example.animeapi.ui.fragments.manga.detail

import com.example.animeapi.base.BaseViewModel
import com.example.animeapi.data.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel @Inject constructor(private val repository: AnimeRepository ) :
    BaseViewModel() {

    fun mangaDetail(id: Int) = repository.mangaDetail(id)
}