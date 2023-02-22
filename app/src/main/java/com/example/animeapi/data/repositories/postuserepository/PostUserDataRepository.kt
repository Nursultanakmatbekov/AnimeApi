package com.example.animeapi.data.repositories.postuserepository

import com.example.animeapi.base.BaseRepository
import com.example.animeapi.data.models.auth.AuthModel
import com.example.animeapi.data.remote.apiservices.SignUpApiService
import javax.inject.Inject

class PostUserDataRepository @Inject constructor(
    private val apiService: SignUpApiService
) : BaseRepository() {
    fun postUserData(authModel: AuthModel) = doRequest {
        apiService.postAuthDataUser(authModel)
    }
}