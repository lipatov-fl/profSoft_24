package com.example.profsoft24.lesson2.data.repositories

import com.example.profsoft24.lesson2.data.api.WeatherServiceClient.weatherApi
import com.example.profsoft24.lesson2.domain.model.Weather
import com.example.profsoft24.lesson2.domain.repository.WeatherDataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object WeatherDataRepositoryImpl : WeatherDataRepository {
    override suspend fun getWeather(): Weather {
        val weather = weatherApi.getWeatherData()
        return Weather(
            city = weather.name,
            temp = weather.main.temp,
            feelsLike = weather.main.feels_like,
            tempMin = weather.main.temp_min,
            tempMax = weather.main.temp_max,
            pressure = weather.main.pressure,
            humidity = weather.main.humidity,
            visibility = weather.visibility,
            windSpeed = weather.wind.speed,
            gust = weather.wind.gust,
            direction = getWindDirection(weather.wind.deg)
        )
    }

    private fun getWindDirection(deg: Int): String {
        return when (deg) {
            in 0..45 -> "N"
            in 46..135 -> "E"
            in 136..225 -> "S"
            in 226..315 -> "W"
            else -> "N"
        }
    }
}