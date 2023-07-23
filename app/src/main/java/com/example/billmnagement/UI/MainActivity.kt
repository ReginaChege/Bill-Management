package com.example.billmnagement.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.billmnagement.Model.LoginRequest
import com.example.billmnagement.R
import com.example.billmnagement.ViewModel.LoginViewModel
import com.example.billmnagement.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onResume(){
        super.onResume()
        validateLogin()
    }
    fun validateLogin(){
        var userName=binding.etusername.text.toString()
        var password=binding.etpassword.text.toString()

        var error=false

        if (userName.isEmpty()){
            binding.etusername.error="Username is required"
            error=true
        }
        if (password.isEmpty()){
            binding.etpassword.error= "Password is required"
            error=true

        }
        if (userName== userName && password==password){
            Toast.makeText(this, "Login sucessfull", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
        }
        if(!error){
            val loginRequest= LoginRequest(
                username=userName,
                password = password,
            )
            LoginViewModel.loginUser(loginRequest)
            Toast.makeText(this,"login was successful",
                Toast.LENGTH_LONG).show()
        }
    }
    fun clearError(){
        binding.tilusername.error=null
        binding.tilpassword.error=null
    }

}