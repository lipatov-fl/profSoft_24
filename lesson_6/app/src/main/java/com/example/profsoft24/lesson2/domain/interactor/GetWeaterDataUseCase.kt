package com.example.profsoft24.lesson2.domain.interactor

import com.example.profsoft24.lesson2.domain.model.Weather
import com.example.profsoft24.lesson2.domain.repository.WeatherDataRepository

class GetWeatherDataUseCase(private val weatherDataRepository: WeatherDataRepository) {

    suspend fun execute(): Weather {
        return weatherDataRepository.getWeather()
    }
}