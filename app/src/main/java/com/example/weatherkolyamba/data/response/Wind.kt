package com.example.weatherkolyamba.data.response

import com.squareup.moshi.Json

data class Wind(
    @field:Json(name ="deg")
    val deg: Int,
    @field:Json(name ="gust")
    val gust: Int,
    @field:Json(name ="speed")
    val speed: Int
)