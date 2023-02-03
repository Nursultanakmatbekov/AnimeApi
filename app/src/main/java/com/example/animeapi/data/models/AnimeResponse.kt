package com.example.animeapi.data.models

import com.google.gson.annotations.SerializedName

data class AnimeResponse<T>(
    @SerializedName("data")
    val data: List<T>?
)