package com.example.fasefinalproject.data.remote


import retrofit2.http.GET

interface ApiService {

    @GET("?inc=name,location,picture")
    suspend fun getContacts(): RandomUserResponse
}