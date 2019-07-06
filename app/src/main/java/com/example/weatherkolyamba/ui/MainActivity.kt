package com.example.weatherkolyamba.ui

import android.os.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherkolyamba.R
import com.example.weatherkolyamba.data.API_KEY
import com.example.weatherkolyamba.data.UNITS
import com.example.weatherkolyamba.data.WeatherApiService
import com.example.weatherkolyamba.data.response.CurrentWeatherResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            btnViewWether.setOnClickListener() {
                println("is work")
            val sityName = etSity.text.toString()

                val router = WeatherApiService.getRouter()
                var req =  router.getCurrentWeather(sityName, UNITS ,API_KEY)
                req.enqueue(object: retrofit2.Callback<CurrentWeatherResponse> {
                    override fun onResponse(call: Call<CurrentWeatherResponse>, response: Response<CurrentWeatherResponse>) {
                        println(response.body()?.main?.temp)

                        val tmp = response.body()?.main?.temp
                        val tmpMax = response.body()?.main?.tempMax

                        btnViewWether.setOnClickListener(
                            tvTmp.setText("$tmp")
                        )

                        btnViewWether.setOnClickListener(
                            tvTmpMax.setText("$tmpMax")
                        )
                    }
                    override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) {}
                })
        }
    }
}

private fun Button.setOnClickListener(text: Unit) {}
