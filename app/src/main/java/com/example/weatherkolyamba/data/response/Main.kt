package com.example.weatherkolyamba.data.response

import com.squareup.moshi.Json

data class Main(
    @field:Json(name ="humidity")
    val humidity: Int,
    @field:Json(name ="pressure")
    val pressure: Int,
    @field:Json(name ="temp")
    var temp: Double,
    @field:Json(name ="temp_max")
    var tempMax: Double,
    @field:Json(name ="temp_min")
    val tempMin: Double
)