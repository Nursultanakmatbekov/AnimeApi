package com.example.animeapi.data.models

import com.example.animeapi.data.models.pagination.Links
import com.google.gson.annotations.SerializedName

data class AnimeResponse<T>(
    @SerializedName("data")
    val data: List<T> ,
    @SerializedName("links")
    val links: Links
)