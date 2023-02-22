package com.example.animeapi.data.remote.apiservices

import com.example.animeapi.data.models.auth.AuthModel
import com.example.animeapi.data.models.auth.TokenModel
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpApiService {

    @POST("oauth/token")
    suspend fun postAuthDataUser(
        @Body authModel: AuthModel
    ): TokenModel
}
