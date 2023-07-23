package com.example.billmnagement.Model

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("first_name")var firstname:String,
    @SerializedName("second_name")var secondname:String,
    var email:String,
    var password:String,


)
