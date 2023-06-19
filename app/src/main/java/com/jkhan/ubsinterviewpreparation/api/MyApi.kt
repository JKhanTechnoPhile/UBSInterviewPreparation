package com.jkhan.ubsinterviewpreparation.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {

    @GET("/comments")
    suspend fun getComments(): Response<List<Comment>>
//    fun getComments(): Call<List<Comment>>
}