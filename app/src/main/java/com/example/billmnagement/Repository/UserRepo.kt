package com.example.billmnagement.Repository

import com.example.billmnagement.Api.ApiClient
import com.example.billmnagement.Model.RegisterRequest
import com.example.billmnagement.Model.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepo {
    var client=ApiClient.buildClient(ApiClient::class.java)
    suspend fun registerUser(registerRequest:RegisterRequest):Response<RegisterResponse>{
        return withContext(Dispatchers.IO){
            client.registerUser(registerRequest)
        }
    }
}