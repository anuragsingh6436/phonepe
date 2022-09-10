package com.example.phonepe.repository

import com.example.phonepe.Network.ApiHelper
import com.example.phonepe.model.response.MovieList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(private val apiHelper: ApiHelper) : MainRepository {

    override suspend fun getUsers(apiKey: String): Flow<MovieList> {
        return flow {
            emit(apiHelper.getUsers(apiKey))
        }
    }

}