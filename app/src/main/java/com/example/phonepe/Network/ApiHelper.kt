package com.example.phonepe.Network

import com.example.phonepe.model.response.MovieList

class ApiHelper(private val apiService: ApiService) {

    suspend fun getUsers(apiKey:String) : MovieList {
        return apiService.getusers(apiKey = apiKey)
    }
}