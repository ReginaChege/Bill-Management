package com.example.billmnagement.Repository

import com.example.billmnagement.Api.ApiClient
import com.example.billmnagement.Model.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginRepo {
    var client=ApiClient.buildClient(ApiClient::class.java)
    suspend fun loginUser(loginRequest: LoginRequest) {
        return withContext(Dispatchers.IO){
            client.loginUser(LoginRequest)
        }
    }

}