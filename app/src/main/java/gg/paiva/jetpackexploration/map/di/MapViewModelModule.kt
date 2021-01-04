package gg.paiva.jetpackexploration.map.di

import gg.paiva.jetpackexploration.map.MapViewModel
import org.koin.dsl.module

val mapViewModelModule = module {
    factory { MapViewModel(get()) }
}
