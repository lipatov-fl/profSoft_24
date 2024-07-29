package com.example.profsoft24.lesson2.data.models

data class CurrentWeather(
    val id: Int,
    val main: Main,
    val name: String,
    val visibility: Double,
    val wind: Wind
)