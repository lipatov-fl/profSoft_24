package com.example.profsoft24.lesson2.domain.model

data class Weather(
    val city: String,
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int,
    val visibility: Double,
    val windSpeed: Double,
    val gust: Double,
    val direction: String
)
