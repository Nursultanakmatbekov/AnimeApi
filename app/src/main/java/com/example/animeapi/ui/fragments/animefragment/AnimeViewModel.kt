package com.example.animeapi.ui.fragments.animefragment

import androidx.lifecycle.ViewModel
import com.example.animeapi.data.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val repository: AnimeRepository) : ViewModel() {

    fun fetchAnime() = repository.fetchAnime()
}