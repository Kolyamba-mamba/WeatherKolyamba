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


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            btnViewWether.setOnClickListener() {
                println("is work")
            val sityName = etSity.text.toString()

                val router = WeatherApiService.getRouter()

                CoroutineScope(Dispatchers.IO).launch {
                    var req = router.getCurrentWeather(sityName, UNITS, LANG, API_KEY)
                    println(req)

                    val tmp = req.main.temp
                    val tmpMax = req.main.tempMax
                    val Description = req.weather[0].description
                    val WindSpeed = req.wind.speed

                    btnViewWether.setOnClickListener(
                        tvTmp.setText("$tmp"),
                        tvTmpMax.setText("$tmpMax"),
                        tvDescription.setText("$Description"),
                        tvWindSpeed.setText("$WindSpeed" + " m/s")
                    )

                }

            }
        }
    }

private fun Button.setOnClickListener(text: Unit, text1: Unit, text2: Unit, text3: Unit) {

}

