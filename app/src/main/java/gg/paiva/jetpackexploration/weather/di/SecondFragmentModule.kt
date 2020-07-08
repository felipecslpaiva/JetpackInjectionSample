package gg.paiva.jetpackexploration.weather.di

import gg.paiva.jetpackexploration.weather.WeatherFragment
import org.koin.dsl.module

val secondFragmentModule = module {
    factory { WeatherFragment() }
}