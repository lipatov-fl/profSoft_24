package com.example.profsoft24.lesson2.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.profsoft24.R
import com.example.profsoft24.databinding.ActivityMainBinding
import com.example.profsoft24.lesson2.data.api.WeatherApi
import com.example.profsoft24.lesson2.domain.model.Weather
import com.example.profsoft24.lesson2.presentation.viewmodel.WeatherDataViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: WeatherDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.toolbar_title)

        viewModel = ViewModelProvider(this).get(WeatherDataViewModel::class.java)
        viewModel.getWeather()

        viewModel.weatherData.observe(this) { weatherData ->
            binding.apply {
                textViewCity.text = weatherData.city
                textViewDegree.text = getString(R.string.temp, weatherData.temp)
                textViewCloudy.text = getString(R.string.feels_like, weatherData.feelsLike)
                textViewWeatherMinMax.text =
                    getString(R.string.weather_min_max, weatherData.tempMin, weatherData.tempMax)
                textViewPressure.text = getString(R.string.pressure, weatherData.pressure)
                textViewHumidity.text = getString(R.string.humidity, weatherData.humidity)
                textViewVisibility.text = getString(R.string.visibility, weatherData.visibility)
                textViewWindSpeed.text = getString(R.string.speed, weatherData.windSpeed)
                textViewGust.text = getString(R.string.gust, weatherData.gust)
                textViewDirection.text = getString(R.string.direction, weatherData.direction)
            }
        }
    }
}