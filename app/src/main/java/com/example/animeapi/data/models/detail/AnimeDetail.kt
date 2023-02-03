package com.example.animeapi.data.models.detail

import com.example.animeapi.data.models.DataItem
import com.google.gson.annotations.SerializedName

data class AnimeDetail(
    @SerializedName("data")
    val data: DataItem
)

