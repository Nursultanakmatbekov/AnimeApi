package com.example.animeapi.ui.fragments.anime

import com.example.animeapi.base.BaseViewModel
import com.example.animeapi.data.repositories.anime.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val repository: AnimeRepository) :
    BaseViewModel() {

    fun fetchAnime() = repository.fetchAnime()
}