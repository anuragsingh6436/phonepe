package com.example.phonepe.repository

import com.example.phonepe.model.response.MovieList
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getUsers(apiKey: String): Flow<MovieList>
}