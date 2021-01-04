package gg.paiva.jetpackexploration.map.di

import gg.paiva.jetpackexploration.map.MapFragment
import org.koin.dsl.module

val mapFragmentModule = module {
    factory { MapFragment() }
}