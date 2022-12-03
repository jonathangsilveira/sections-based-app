package com.example.jonathan.data

import com.example.jonathan.data.request.HomeRequestData
import com.example.jonathan.data.response.HomeResponse
import retrofit2.http.Body
import retrofit2.http.POST

internal interface HomeService {
    @POST("home")
    suspend fun getHome(@Body request: HomeRequestData): HomeResponse
}