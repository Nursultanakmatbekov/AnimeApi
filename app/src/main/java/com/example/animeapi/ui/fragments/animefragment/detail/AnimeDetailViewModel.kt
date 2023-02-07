package com.example.animeapi.ui.fragments.animefragment.detail

import com.example.animeapi.base.BaseViewModel
import com.example.animeapi.data.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(private val repository: AnimeRepository) :
    BaseViewModel() {

    fun animeDetail(id: Int) = repository.animeDetail(id)
}