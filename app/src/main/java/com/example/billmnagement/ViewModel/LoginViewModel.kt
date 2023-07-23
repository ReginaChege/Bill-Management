package com.example.billmnagement.ViewModel

import androidx.lifecycle.MutableLiveData
import com.example.billmnagement.Model.LoginRequest

class LoginViewModel {    val logLiveData= MutableLiveData<LoginRequest>()
    val errorLiveData= MutableLiveData<String>()
    val loginRepository=LoginRequest()
    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch{
            val response= loginRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                logLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}