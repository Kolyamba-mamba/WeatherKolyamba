package com.example.weatherkolyamba.ui

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.weatherkolyamba.R
import com.example.weatherkolyamba.data.API_KEY
import com.example.weatherkolyamba.data.UNITS
import com.example.weatherkolyamba.data.WeatherApiService
import com.example.weatherkolyamba.data.response.CurrentWeatherResponse
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            val button = findViewById<Button>(R.id.btn)
            val ViewTmp = findViewById<TextView>(R.id.tmp)
            val ViewTmpMax = findViewById<TextView>(R.id.tmpMax)
            val EditText = findViewById<EditText>(R.id.sity)

            button.setOnClickListener() {
                println("is work")
            val sityName = EditText.getText().toString()

                val router = WeatherApiService.getRouter()
                var req = router.getCurrentWeather(sityName, UNITS ,API_KEY)
                req.enqueue(object: retrofit2.Callback<CurrentWeatherResponse> {
                    override fun onResponse(call: Call<CurrentWeatherResponse>, response: Response<CurrentWeatherResponse>) {
                        println(response.body()?.main?.temp)

                        val tmp = response.body()?.main?.temp
                        val tmpMax = response.body()?.main?.tempMax

                        button.setOnClickListener(
                            ViewTmp.setText("$tmp")
                        )

                        button.setOnClickListener(
                            ViewTmpMax.setText("$tmpMax")
                        )
                    }
                    override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) {}
                })

        }

    }
}

private fun Button.setOnClickListener(text: Unit) {

}
