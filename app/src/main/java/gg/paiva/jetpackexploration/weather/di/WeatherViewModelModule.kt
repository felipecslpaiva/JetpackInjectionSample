package gg.paiva.jetpackexploration.weather.di

import gg.paiva.jetpackexploration.weather.WeatherViewModel
import org.koin.dsl.module

val weatherViewModelModule = module {
    factory { WeatherViewModel(get()) }
}
