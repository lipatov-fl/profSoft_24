package com.example.profsoft24.lesson2.di

import com.example.profsoft24.lesson2.domain.interactor.GetWeatherDataUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetWeatherDataUseCase(get()) }
}