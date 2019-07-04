package com.example.weatherkolyamba.data.response


import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("deg")
    val deg: Int,
    @SerializedName("gust")
    val gust: Int,
    @SerializedName("speed")
    val speed: Int
)