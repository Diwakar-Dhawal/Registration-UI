package com.example.registration_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.registration_ui.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private  val binding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Handler(Looper.getMainLooper()).postDelayed({
            var intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()

        },2000)

    }
}