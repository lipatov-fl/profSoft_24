package com.example.profsoft24.lesson2.data.api

import com.example.profsoft24.lesson2.data.models.CurrentWeather
import retrofit2.http.GET

interface WeatherApi {
    @GET("weather?q=Saratov&appid=6d58e901d98c4f1c72a66323dbf111c5&units=metric")
    suspend fun getWeatherData(): CurrentWeather
}