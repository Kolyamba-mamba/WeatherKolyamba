package com.example.weatherkolyamba.data.response

import com.squareup.moshi.Json

data class Sys(
    @field:Json(name ="country")
    val country: String,
    @field:Json(name ="id")
    val id: Int,
    @field:Json(name ="message")
    val message: Double,
    @field:Json(name ="sunrise")
    val sunrise: Int,
    @field:Json(name ="sunset")
    val sunset: Int,
    @field:Json(name ="type")
    val type: Int
)