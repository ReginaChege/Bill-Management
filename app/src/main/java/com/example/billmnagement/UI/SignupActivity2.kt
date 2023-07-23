package com.example.billmnagement.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.billmnagement.Model.RegisterRequest
import com.example.billmnagement.ViewModel.UserViewModel
import com.example.billmnagement.databinding.ActivitySignup2Binding

class SignupActivity2 : AppCompatActivity() {
    lateinit var binding: ActivitySignup2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignup2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
    }
    fun validateSignUp(){
        val first = binding.etfirstname.text.toString()
        val second=binding.etsecondname.text.toString()
        val email=binding.etemail.text.toString()
        val password=binding.etpassword.text.toString()
        val passwordconfiq=binding.etpasswordconfiq.text.toString()
        var error=true
    if (first.isEmpty()){
        binding.etfirstname.error="firstname required"
        error=true

    }
        if (second.isEmpty()){
            binding.etsecondname.error="Second name required"
            error=true

        }
        if (email.isEmpty()){
            binding.etemail.error="Email required"
            error=true

        }
        if (password.isEmpty()){
            binding.etpassword.error="Password required"
            error=true

        }
        if (passwordconfiq.isEmpty()){
            binding.etpasswordconfiq.error="Password required"
            error=true

        }
        if (password !=passwordconfiq){
           binding.etpasswordconfiq.error="Password confirmation doesn't match password"
            error=true
        }
        if(!error){
            val registerRequest= RegisterRequest(
                firstname =first,
                secondname = second,
                email=email,
                password = password,
            )
            UserViewModel.registerUser(registerRequest)
            Toast.makeText(this,"Registration of $first" +
                    " was sucessful",
                Toast.LENGTH_LONG).show()
        }

    }
    fun clearError(){
        binding.etfirstname.error=null
        binding.etsecondname.error=null
        binding.etemail.error=null
        binding.etpassword.error=null
        binding.etpasswordconfiq.error=null
    }
}