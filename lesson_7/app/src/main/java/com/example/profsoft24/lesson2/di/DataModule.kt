package com.example.profsoft24.lesson2.di

import com.example.profsoft24.lesson2.data.repositories.WeatherDataRepositoryImpl
import com.example.profsoft24.lesson2.domain.repository.WeatherDataRepository
import org.koin.dsl.module

val dataModule = module {
    single<WeatherDataRepository> { WeatherDataRepositoryImpl() }
}