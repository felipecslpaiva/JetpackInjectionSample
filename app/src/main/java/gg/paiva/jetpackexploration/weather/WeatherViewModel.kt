package gg.paiva.jetpackexploration.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import gg.paiva.jetpackexploration.weather.models.Weather
import gg.paiva.jetpackexploration.weather.repo.WeatherRepository
import kotlinx.coroutines.Dispatchers

class WeatherViewModel(
    private val weatherRepo: WeatherRepository
) : ViewModel() {

    private val location = MutableLiveData<String>()

    fun getWeather(input: String) {
        location.value = input
    }

    var  weather: LiveData<Weather> =
        liveData(Dispatchers.IO) {
            emit(weatherRepo.getWeather())
        }
}