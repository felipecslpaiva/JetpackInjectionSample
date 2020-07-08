package gg.paiva.jetpackexploration.base

import gg.paiva.jetpackexploration.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val deviceModel : String) : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val url = req.url().newBuilder()
            .addQueryParameter("APPID", BuildConfig.API_KEY).build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }
}