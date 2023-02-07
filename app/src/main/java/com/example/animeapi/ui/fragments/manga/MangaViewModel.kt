package com.example.animeapi.ui.fragments.manga

import com.example.animeapi.base.BaseViewModel
import com.example.animeapi.data.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(private val repository: AnimeRepository) :
    BaseViewModel() {

    fun fetchManga() = repository.fetchManga()
}