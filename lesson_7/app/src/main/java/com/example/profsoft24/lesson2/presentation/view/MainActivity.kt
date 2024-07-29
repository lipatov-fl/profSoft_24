package com.example.profsoft24.lesson2.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.profsoft24.R
import com.example.profsoft24.databinding.ActivityMainBinding
import com.example.profsoft24.lesson2.presentation.viewmodel.WeatherDataViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherDataViewModel by viewModel<WeatherDataViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.toolbar_title)

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