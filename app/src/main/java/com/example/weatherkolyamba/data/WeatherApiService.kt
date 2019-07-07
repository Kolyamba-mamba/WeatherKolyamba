package com.example.weatherkolyamba.data

import com.example.weatherkolyamba.data.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY = "54a4865f9565f4c6e06e17f6b37b3d47"
const val BASE_URL = "http://api.openweathermap.org/data/2.5/"
const val UNITS = "metric"
const val LANG = "ru"

//http://api.openweathermap.org/data/2.5/weather?q=Moscow&units=metric&appid=54a4865f9565f4c6e06e17f6b37b3d47

interface WeatherApiService {

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") location: String,
        @Query("units") units: String,
        @Query("lang") lang: String,
        @Query("appid") apiId: String
    ): CurrentWeatherResponse


    companion object Factory {
        val shared: WeatherApiService by lazy(LazyThreadSafetyMode.PUBLICATION) {
            return@lazy getNewRouter().create(WeatherApiService::class.java)
        }

        private fun getNewRouter() = retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}