package gg.paiva.jetpackexploration.map.di

import gg.paiva.jetpackexploration.map.repo.CamerasRepository
import org.koin.dsl.module

val cameraRepositoryModule = module {
    factory { CamerasRepository(get()) }
}