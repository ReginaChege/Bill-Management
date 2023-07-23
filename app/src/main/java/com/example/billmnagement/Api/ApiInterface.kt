package com.example.billmnagement.Api

import com.example.billmnagement.Model.LoginResponse
import com.example.billmnagement.Model.RegisterRequest
import com.example.billmnagement.Model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("/users/register")
    suspend fun register(@Body registerRequest: RegisterRequest):Response<RegisterResponse>
    @POST("/users/Login")
    suspend fun loginUser(@Body loginResponse: LoginResponse):Response<LoginResponse>
}