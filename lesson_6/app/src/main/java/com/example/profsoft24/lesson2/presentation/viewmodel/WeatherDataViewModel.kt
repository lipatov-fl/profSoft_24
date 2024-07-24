package com.example.profsoft24.lesson2.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profsoft24.lesson2.data.repositories.WeatherDataRepositoryImpl
import com.example.profsoft24.lesson2.domain.interactor.GetWeatherDataUseCase
import com.example.profsoft24.lesson2.domain.model.Weather
import kotlinx.coroutines.launch

class WeatherDataViewModel() : ViewModel() {
    private val repository = WeatherDataRepositoryImpl
    private val getWeatherDataUseCase = GetWeatherDataUseCase(repository)
    val weatherData = MutableLiveData<Weather>()

    fun getWeather() {
        viewModelScope.launch {
            try {
                val weather = getWeatherDataUseCase.execute()
                val tempMin = weather.tempMin
                val tempMax = weather.tempMax
                Log.d("WeatherData", "TempMin: $tempMin, TempMax: $tempMax")
                weatherData.postValue(weather)
            } catch (e: Exception) {
                Log.e("WeatherData", "Error fetching weather data: ${e.message}")
            }
        }
    }
}