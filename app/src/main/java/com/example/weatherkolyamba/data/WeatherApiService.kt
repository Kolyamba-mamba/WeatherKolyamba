package com.example.weatherkolyamba.data

import com.example.weatherkolyamba.data.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY = "54a4865f9565f4c6e06e17f6b37b3d47"

//http://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=54a4865f9565f4c6e06e17f6b37b3d47

interface WeatherApiService {

    @GET("weather")
    fun getCurrentWeather(
        @Query("q") location: String,
        @Query("appid") apiId: String
    ): Call<CurrentWeatherResponse>


    companion object Factory {
        fun getRouter(): WeatherApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(WeatherApiService::class.java)
        }
    }
}
