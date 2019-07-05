package com.example.weatherkolyamba.data.response


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

public data class Main(
    @field:Json(name ="humidity")
    val humidity: Int,
    @field:Json(name ="pressure")
    val pressure: Int,
    @field:Json(name ="temp")
    val temp: Double,
    @field:Json(name ="temp_max")
    val tempMax: Double,
    @field:Json(name ="temp_min")
    val tempMin: Double
)