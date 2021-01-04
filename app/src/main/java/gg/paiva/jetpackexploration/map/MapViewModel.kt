package gg.paiva.jetpackexploration.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import gg.paiva.jetpackexploration.map.models.CameraModelRoot
import gg.paiva.jetpackexploration.map.repo.CamerasRepository
import kotlinx.coroutines.Dispatchers

class MapViewModel(
    private val camerasRepository: CamerasRepository
) : ViewModel() {

    private val location = MutableLiveData<String>()

    fun getWeather(input: String) {
        location.value = input
    }

    var  CameraModelRoot: LiveData<CameraModelRoot> =
        liveData(Dispatchers.IO) {
            emit(camerasRepository.getCameras())
        }
}