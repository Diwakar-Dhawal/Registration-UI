package com.example.registration_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registration_ui.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.signupLogin.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}