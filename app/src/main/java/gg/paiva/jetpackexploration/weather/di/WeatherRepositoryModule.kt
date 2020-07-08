package gg.paiva.jetpackexploration.weather.di

import gg.paiva.jetpackexploration.weather.repo.WeatherRepository
import org.koin.dsl.module

val weatherRepositoryModule = module {
    factory { WeatherRepository(get()) }
}