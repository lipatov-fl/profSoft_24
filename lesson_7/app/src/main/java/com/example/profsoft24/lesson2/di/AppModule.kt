package com.example.profsoft24.lesson2.di

import com.example.profsoft24.lesson2.presentation.viewmodel.WeatherDataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<WeatherDataViewModel> { WeatherDataViewModel() }
}