package gg.paiva.jetpackexploration.session.network

import retrofit2.http.GET


interface ProfileService{

    @GET("/api")
    suspend fun getUserForSession(){

    }
}