package com.example.animeapi.ui.fragments.singup

import com.example.animeapi.base.BaseViewModel
import com.example.animeapi.data.models.auth.AuthModel
import com.example.animeapi.data.repositories.anime.AnimeRepository
import com.example.animeapi.data.repositories.postuserepository.PostUserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SingUpViewModel @Inject constructor(
    private val repository: PostUserDataRepository
) : BaseViewModel() {

    fun postUserData(authModel: AuthModel) = repository.postUserData(authModel)
}