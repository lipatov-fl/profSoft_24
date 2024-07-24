package com.example.profsoft24.lesson2.domain.repository

import com.example.profsoft24.lesson2.domain.model.Weather

interface WeatherDataRepository {
    suspend fun getWeather(): Weather
}