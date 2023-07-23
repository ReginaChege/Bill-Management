package com.example.billmnagement.ViewModel

import androidx.lifecycle.MutableLiveData
import com.example.billmnagement.Model.RegisterRequest
import com.example.billmnagement.Model.RegisterResponse
import com.example.billmnagement.Repository.UserRepo

class UserViewModel {
    val regLiveData=MutableLiveData<RegisterResponse>()
    val errorLiveData= MutableLiveData<String>()
    val userRepository= UserRepo()
    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response= userRepository.registerUser(registerRequest)
            if (response.isSuccessful){
                regLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}