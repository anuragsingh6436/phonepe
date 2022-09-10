package com.example.phonepe.Network

import com.example.phonepe.model.response.MovieList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("popular?")
    suspend fun getusers(@Query("api_key")apiKey:String): MovieList

}