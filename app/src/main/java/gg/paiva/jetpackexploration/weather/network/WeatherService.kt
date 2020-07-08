package gg.paiva.jetpackexploration.weather.network

import gg.paiva.jetpackexploration.weather.models.Weather
import retrofit2.http.GET


interface WeatherService{
    @GET("weather?id=524901")
    suspend fun getForecast() : Weather
}