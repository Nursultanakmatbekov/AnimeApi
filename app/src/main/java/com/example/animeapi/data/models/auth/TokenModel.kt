package com.example.animeapi.data.models.auth

import com.google.gson.annotations.SerializedName

class TokenModel (

    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("refresh_token")
    val refreshToken: String,

    )