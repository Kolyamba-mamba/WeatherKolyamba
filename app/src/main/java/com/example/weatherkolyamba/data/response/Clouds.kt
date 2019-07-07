package com.example.weatherkolyamba.data.response

import com.squareup.moshi.Json

data class Clouds(
    @field:Json(name = "all")
    val all: Int
)