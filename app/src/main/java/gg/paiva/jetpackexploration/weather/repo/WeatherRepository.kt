package gg.paiva.jetpackexploration.weather.repo

import gg.paiva.jetpackexploration.weather.network.WeatherService

class WeatherRepository(private val weatherApi: WeatherService) {
    suspend fun getWeather() = weatherApi.getForecast()
}