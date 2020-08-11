package gg.paiva.jetpackexploration.map.repo

import gg.paiva.jetpackexploration.map.network.CameraService

class CamerasRepository(private val cameraApi: CameraService) {
    suspend fun getCameras() = cameraApi.getCameras()
}