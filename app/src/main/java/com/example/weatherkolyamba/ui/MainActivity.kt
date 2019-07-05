package com.example.weatherkolyamba.ui

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.view.menu.MenuPresenter
import com.example.weatherkolyamba.R
import com.example.weatherkolyamba.data.API_KEY
import com.example.weatherkolyamba.data.WeatherApiService
import com.example.weatherkolyamba.data.response.CurrentWeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Runnable
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            val button = findViewById<Button>(R.id.btn)
            val tView = findViewById<TextView>(R.id.txt_result)
            val EditText = findViewById<EditText>(R.id.sity)
            tView.setText("HEY")
            button.setOnClickListener() {
                println("is work")
            val sityName = EditText.getText().toString()

                val router = WeatherApiService.getRouter()
                var req = router.getCurrentWeather(sityName,API_KEY)
                req.enqueue(object: retrofit2.Callback<CurrentWeatherResponse> {
                    override fun onResponse(call: Call<CurrentWeatherResponse>, response: Response<CurrentWeatherResponse>) {
                        println(response.body())

                        button.setOnClickListener(
                            tView.setText("${response.body()}")

                        )
                    }
                    override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) {}
                })
                
        }

    }
}

private fun Button.setOnClickListener(text: Unit) {

}
