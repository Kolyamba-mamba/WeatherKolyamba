package com.example.weatherkolyamba.ui

import android.os.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherkolyamba.R
import com.example.weatherkolyamba.data.API_KEY
import com.example.weatherkolyamba.data.LANG
import com.example.weatherkolyamba.data.UNITS
import com.example.weatherkolyamba.data.WeatherApiService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            btnViewWether.setOnClickListener() {
                println("is work")
            val cityName = etCity.text.toString()

                val router = WeatherApiService.Factory.shared

                CoroutineScope(Dispatchers.IO).launch {
                    var req = router.getCurrentWeather(cityName, UNITS, LANG, API_KEY)
                    println(req)

                        val tmp = req.main.temp
                        val tmpMax = req.main.tempMax
                        val Description = req.weather[0].description
                        val WindSpeed = req.wind.speed

                    withContext(Dispatchers.Main) {
                        tvTmp.setText("$tmp")
                        tvTmpMax.setText("$tmpMax")
                        tvDescription.setText(Description)
                        tvWindSpeed.setText("$WindSpeed m/s")
                    }
                }
            }
        }
    }

