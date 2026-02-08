package com.example.fasefinalproject.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
)
    {

    suspend fun getContacts(): RandomUserResponse {
        return apiService.getContacts()
    }
}
