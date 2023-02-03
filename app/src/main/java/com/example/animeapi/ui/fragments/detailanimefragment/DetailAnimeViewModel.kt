package com.example.animeapi.ui.fragments.detailanimefragment

import androidx.lifecycle.ViewModel
import com.example.animeapi.data.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailAnimeViewModel @Inject constructor(private val repository: AnimeRepository) :
    ViewModel() {

    fun animeDetail(id: Int) = repository.animeDetail(id)
}