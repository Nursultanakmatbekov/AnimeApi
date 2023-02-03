package com.example.animeapi.data.models

import com.google.gson.annotations.SerializedName

data class DataItem(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("type")
    val type: String = ""
)