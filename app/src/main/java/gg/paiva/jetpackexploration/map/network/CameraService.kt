package gg.paiva.jetpackexploration.map.network

import gg.paiva.jetpackexploration.map.models.CameraModelRoot
import retrofit2.http.GET

interface CameraService{
    @GET("https://api.data.gov.sg/v1/transport/traffic-images")
    suspend fun getCameras() : CameraModelRoot
}