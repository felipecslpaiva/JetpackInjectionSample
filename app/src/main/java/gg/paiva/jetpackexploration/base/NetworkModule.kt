package gg.paiva.jetpackexploration.base

import gg.paiva.jetpackexploration.BuildConfig.API_URL
import gg.paiva.jetpackexploration.weather.network.WeatherService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { deviceInfo() }
    factory { AuthInterceptor(get()) }
    factory { provideOkHttpClient(get()) }
    factory { provideForecastApi(get()) }
    single { provideRetrofit(get()) }
}

fun deviceInfo() = "Test Device"

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder().baseUrl(API_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient =
    OkHttpClient()
        .newBuilder()
        .addInterceptor(authInterceptor)
        .build()

fun provideForecastApi(retrofit: Retrofit): WeatherService =
    retrofit.create(WeatherService::class.java)